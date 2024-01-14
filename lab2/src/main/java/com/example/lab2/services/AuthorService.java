package com.example.lab2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.lab2.repositories.AuthorRepository;
import com.example.lab2.models.AuthorEntity;
import com.example.lab2.models.dto.AuthorRequest;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final ObjectMapper objectMapper;

    private final AuthorRepository authorRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(authorRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(AuthorRequest authorRequest){
        AuthorEntity author = new AuthorEntity(randomUUID(), authorRequest.getName());
        authorRepository.save(author);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID director_id) {
        authorRepository.deleteById(director_id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
