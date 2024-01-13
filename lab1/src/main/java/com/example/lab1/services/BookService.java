package com.example.lab1.services;

import com.example.lab1.repositories.BookRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab1.models.BookEntity;
import com.example.lab1.models.dto.BookRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class BookService {
    @Inject
    private BookRepository bookRepository;

    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    public UUID create(BookRequest bookRequest) {
        BookEntity book = new BookEntity(randomUUID(), bookRequest.getTitle(), bookRequest.getLitGenre(), bookRequest.getAuthorID());
        bookRepository.persist(book);
        return book.getId();
    }

    public void delete(UUID bookID) {
        bookRepository.delete(bookID);
    }
}
