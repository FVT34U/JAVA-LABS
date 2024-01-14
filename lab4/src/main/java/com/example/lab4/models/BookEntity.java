package com.example.lab4.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @Column(name = "id")
    private UUID ID;

    @Column(name = "title")
    private String title;

    @Column(name = "litgenre")
    private String litGenre;

    @Column(name = "authorid")
    private UUID authorID;
}
