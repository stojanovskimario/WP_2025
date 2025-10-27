package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private final BookRepository bookRepository;

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll(); // inMemoryBookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);  // inMemoryBookRepository.searchBooks();
    }
}
