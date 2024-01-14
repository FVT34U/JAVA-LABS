package com.example.lab4.controllers;


import com.example.lab4.models.dto.BookRequest;
import com.example.lab4.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> getAll() {
        return bookService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody BookRequest bookRequest) {

        return bookService.create(bookRequest);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return bookService.delete(id);
    }

}
