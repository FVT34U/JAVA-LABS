package com.example.lab4.models.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class BookRequest {
    private String title;
    private String litGenre;
    private UUID authorID;
}
