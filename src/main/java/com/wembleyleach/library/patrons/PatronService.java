package com.wembleyleach.library.patrons;

import org.springframework.stereotype.Service;

@Service
public class PatronService {

    private final PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public synchronized Patron addPatron(Patron patron) {
        patronRepository.addPatron(patron);
        return patronRepository.getPatronById(patron.getId());
    }

    public Patron getPatronById(long patronId) {
        return patronRepository.getPatronById(patronId);
    }

    public Patron updatePatron(Patron patron) {
        patronRepository.updatePatron(patron);
        return patronRepository.getPatronById(patron.getId());
    }

    public void deletePatron(long patronId) {
        patronRepository.deletePatron(patronId);
    }
}
