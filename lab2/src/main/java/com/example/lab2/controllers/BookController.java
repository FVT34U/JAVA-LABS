package com.example.lab2.controllers;

import com.example.lab2.models.dto.BookRequest;
import com.example.lab2.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<String> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/books")
    @SneakyThrows
    public ResponseEntity <String> create(@RequestBody BookRequest bookRequest) {

        return bookService.create(bookRequest);

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity <String> delete(@PathVariable UUID id) {
        return bookService.delete(id);
    }

}

