package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
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

    @Override
    public Book save(String title, String genre, Double averageRating, Author author) {
        Book book = new Book(title, genre, averageRating, author);
        return bookRepository.save(book);
    }

    @Override
    public Book edit(Long id, String title, String genre, Double averageRating, Author author) {
        List<Book> books = bookRepository.findAll();
        for (Book b : books) {
            if (b.getId()==(id)) {
                b.setTitle(title);
                b.setGenre(genre);
                b.setAverageRating(averageRating);
                b.setAuthor(author);
                return b;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        List<Book> books = bookRepository.findAll();
        books.removeIf(book -> book.getId()==(id));
    }
}
