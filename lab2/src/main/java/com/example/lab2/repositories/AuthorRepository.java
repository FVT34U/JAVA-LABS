package com.example.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab2.models.AuthorEntity;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {
}
