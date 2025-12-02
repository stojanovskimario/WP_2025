package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    // lista
    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> listAllByAuthorId(Long authorId) {
        return bookRepository.findAllByAuthor_Id(authorId);
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.findAllByTitleAndAverageRatingGreaterThanEqual(text, rating);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void addBook(String title, String genre, Double averageRating, Long authorId) {
        Author author = authorService.findById(authorId);
        Book book = new Book(title, genre, averageRating, author);
        bookRepository.save(book);
    }

    @Override
    public void editBook(Long bookId, String title, String genre, Double averageRating, Long authorId) {
        Author author = authorService.findById(authorId);
        Book book = bookRepository.findById(bookId).get();
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
