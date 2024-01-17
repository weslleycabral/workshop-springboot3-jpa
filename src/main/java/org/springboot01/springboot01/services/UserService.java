package org.springboot01.springboot01.services;

import jakarta.persistence.EntityNotFoundException;
import org.springboot01.springboot01.entities.User;
import org.springboot01.springboot01.repositories.UserRepository;
import org.springboot01.springboot01.services.exceptions.DatabaseException;
import org.springboot01.springboot01.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    };

    public User finById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert (User user) {
        return repository.save(user);
    }

    public void delete (Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update (Long id, User user) {
        try {
            User updatedUser = repository.getReferenceById(id);
            updateData(updatedUser, user);
            return repository.save(updatedUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User updatedUser, User user) {
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
    }
}
