package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class DataHolder {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public static List<BookReservation> reservations = new ArrayList<>();

    @PostConstruct
    public void initializeData() {
        for (int i = 0; i < 3; i++) {
            Author author = new Author(
                    "Name" + i,
                    "Surname" + i,
                    "Country" + i,
                    "Biography" + i
            );
            authorRepository.save(author);
        }


        for (int i = 0; i < 10; i++) {
            Book book = new Book("Title" + i, "Genre" + i, i, authorRepository.findById(1L).get());
            bookRepository.save(book);
        }
    }
}
