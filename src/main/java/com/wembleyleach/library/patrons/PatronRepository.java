package com.wembleyleach.library.patrons;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PatronRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Patron getPatronById(long patronId) {
        return entityManager.find(Patron.class, patronId);
    }

    public void addPatron(Patron patron) {
        entityManager.persist(patron);
    }

    public void deletePatron(long patronId) {
        entityManager.remove(getPatronById(patronId));
    }

    public void updatePatron(Patron patron) {
        var p = getPatronById(patron.getId());
        p.setBirthdate(patron.getBirthdate());
        p.setName(patron.getName());
        entityManager.flush();
    }
}
