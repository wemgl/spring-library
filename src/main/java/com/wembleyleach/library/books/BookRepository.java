package com.wembleyleach.library.books;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BookRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Book getBookById(long bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(long bookId, Book book) {
        var b = getBookById(bookId);
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setCheckoutDate(book.getCheckoutDate());
        b.setReturnDate(book.getReturnDate());
        b.setCheckedOut(book.isCheckedOut());
        b.setPatron(book.getPatron());
        entityManager.flush();
    }

    public void deleteBook(long bookId) {
        entityManager.remove(getBookById(bookId));
    }
}
