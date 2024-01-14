package com.example.lab3.controllers;

import com.example.lab3.models.dto.AuthorRequest;
import com.example.lab3.services.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping(value = "/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAll() {
        return authorService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody AuthorRequest authorRequest) {

        return authorService.create(authorRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return authorService.delete(id);
    }
}
