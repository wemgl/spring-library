package com.wembleyleach.library.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1", headers = "Accept=application/json")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    @ResponseBody
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book getBook(@PathVariable(name = "bookId") long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Book updateBook(@PathVariable("bookId") long bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }
}
