package com.example.lab3.controllers;

import com.example.lab3.services.AuthorService;
import com.example.lab3.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final AuthorService authorService;

    private final BookService bookService;

    @GetMapping(value = "/authors_xml")
    public String getAuthors(Model model) throws Exception {
        return authorService.getAuthors(model);
    }

    @GetMapping(value = "/books_xml")
    public String getBooks(Model model) throws Exception {
        return bookService.getBooks(model);
    }
}