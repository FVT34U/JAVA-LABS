package com.example.lab1.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookRequest {
    private String title;
    private UUID authorID;
    private String litGenre;
}
