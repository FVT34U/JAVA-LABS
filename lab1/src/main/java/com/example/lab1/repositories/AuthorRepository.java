package com.example.lab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.AuthorEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class AuthorRepository {
    @PersistenceContext
    private EntityManager em;

    public List<AuthorEntity> findAll() {
        return em.createQuery("select i from AuthorEntity i", AuthorEntity.class).getResultList();
    }

    public void persist(AuthorEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID departmentId) {
        AuthorEntity entity = em.find(AuthorEntity.class, departmentId);
        em.remove(entity);
    }
}
