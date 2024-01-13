package com.example.lab1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.BookEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class BookRepository {
    @PersistenceContext
    private EntityManager em;

    public List<BookEntity> findAll() {
        return em.createQuery("select i from BookEntity i", BookEntity.class).getResultList();
    }

    public void persist(BookEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID departmentId) {
        BookEntity entity = em.find(BookEntity.class, departmentId);
        em.remove(entity);
    }
}
