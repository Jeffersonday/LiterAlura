package com.alura.literalura.Service;

import com.alura.literalura.dto.GutendexBook;
import com.alura.literalura.dto.GutendexResponse;
import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private static final String API_URL = "https://gutendex.com/books?title=";

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book fetchAndSaveBook(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + title;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            GutendexBook gutendexBook = response.getResults().get(0);

            Author author = new Author();
            author.setName(gutendexBook.getAuthorName());
            author.setBirthYear(gutendexBook.getBirthYear());
            author.setDeathYear(gutendexBook.getDeathYear());

            Book book = new Book();
            book.setTitle(gutendexBook.getTitle());
            book.setLanguage(gutendexBook.getLanguage());
            book.setDownloadCount(gutendexBook.getDownloadCount());
            book.setAuthor(author);

            authorRepository.save(author);
//            bookRepository.save(book);

            return book;
        }

        return null;
    }

    public List<java.awt.print.Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    public List<java.awt.print.Book> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<java.awt.print.Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}


