package com.example.lab1.services;

import com.example.lab1.repositories.AuthorRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab1.models.AuthorEntity;
import com.example.lab1.models.dto.AuthorRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class AuthorService {
    @Inject
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }

    public UUID create(AuthorRequest authorRequest) {
        AuthorEntity author = new AuthorEntity(randomUUID(), authorRequest.getName());
        authorRepository.persist(author);
        return author.getId();
    }

    public void delete(UUID authorID) {
        authorRepository.delete(authorID);
    }
}
