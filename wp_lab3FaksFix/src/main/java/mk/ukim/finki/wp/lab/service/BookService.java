package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> listAll();
    List<Book> listAllByAuthorId(Long authorId);
    List<Book> searchBooks(String text, Double rating);
    Book findById(Long id);
    void addBook(String title, String genre, Double averageRating, Long authorId);
    void editBook(Long bookId, String title, String genre, Double averageRating, Long authorId);
    void deleteBook(Long id);
    //List<Book> filterBooks(String title, Double rating, Long authorId);
    Page<Book> filterBooks(String title, Double rating, Long authorId, Pageable pageable);
}
