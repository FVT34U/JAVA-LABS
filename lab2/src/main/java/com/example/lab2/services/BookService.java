package com.example.lab2.services;

import com.example.lab2.models.BookEntity;
import com.example.lab2.models.dto.BookRequest;
import com.example.lab2.repositories.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final ObjectMapper objectMapper;

    private final BookRepository bookRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(bookRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(BookRequest bookRequest){
        BookEntity book = new BookEntity(randomUUID(), bookRequest.getTitle(), bookRequest.getLitGenre(), bookRequest.getAuthorID());
        bookRepository.save(book);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID book_id) {
        bookRepository.deleteById(book_id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
