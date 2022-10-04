package com.forum.app.api.com.forum.app.api.controllers;

import com.forum.app.api.com.forum.app.api.models.User;
import com.forum.app.api.com.forum.app.api.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v2/users")
public class UserController {

    @Autowired
    private UserRepository _repository;

    @GetMapping()
    public ResponseEntity<List<User>> getUserById(@RequestParam(required = false) Optional<String> id) {

        List<User> user = id.isPresent() ? _repository.findById(id.get())
                .stream().toList() : _repository.findAll();

        return user.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
