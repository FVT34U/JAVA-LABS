package com.example.lab2.controllers;

import com.example.lab2.models.dto.AuthorRequest;
import com.example.lab2.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<String> getAll() {
        return authorService.getAll();
    }

    @PostMapping("/authors")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody AuthorRequest authorRequest) {

        return authorService.create(authorRequest);

    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return authorService.delete(id);
    }

}

