package com.joaozada.hruser.resources;

import com.joaozada.hruser.entities.User;
import com.joaozada.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserRepository repo;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User worker = repo.findById(id).get();
        return ResponseEntity.ok(worker);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        User obj = repo.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}