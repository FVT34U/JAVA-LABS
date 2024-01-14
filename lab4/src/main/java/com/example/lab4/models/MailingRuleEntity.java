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
@Table(name = "mailing_rules")
public class MailingRuleEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "tablename")
    private String tableName;

    @Column(name = "email")
    private String email;
}
