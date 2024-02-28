package org.example.petproject.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.petproject.entity.Language;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguageService {

    @PersistenceContext
    EntityManager em;

    public void save(Language language) {
        em.persist(language);
    }
}
