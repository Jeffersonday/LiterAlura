package com.alura.literalura.controller;

import com.alura.literalura.Service.BookService;
import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public Book searchBook(@RequestParam String title) {
        return bookService.fetchAndSaveBook(title);
    }

    @GetMapping
    public List<java.awt.print.Book> listAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/authors")
    public List<Author> listAllAuthors() {
        return bookService.listAllAuthors();
    }

    @GetMapping("/language/{language}")
    public List<java.awt.print.Book> findBooksByLanguage(@PathVariable String language) {
        return bookService.findBooksByLanguage(language);
    }

    @GetMapping("/title/{title}")
    public List<java.awt.print.Book> findBooksByTitle(@PathVariable String title) {
        return bookService.findBooksByTitle(title);
    }
}
