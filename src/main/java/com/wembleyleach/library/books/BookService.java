package com.wembleyleach.library.books;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public synchronized Book addBook(Book book) {
        bookRepository.addBook(book);
        return bookRepository.getBookById(book.getId());
    }

    public Book updateBook(long bookId, Book book) {
        bookRepository.updateBook(bookId, book);
        return bookRepository.getBookById(bookId);
    }

    public Book getBookById(long bookId) {
        return bookRepository.getBookById(bookId);
    }

    public void deleteBook(long bookId) {
        bookRepository.deleteBook(bookId);
    }
}
