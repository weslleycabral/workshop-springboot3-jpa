package org.springboot01.springboot01.resources;

import org.springboot01.springboot01.entities.User;
import org.springboot01.springboot01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> finById(@PathVariable Long id) {
        User obj = userService.finById(id);
        return ResponseEntity.ok().body(obj);
    }
}
