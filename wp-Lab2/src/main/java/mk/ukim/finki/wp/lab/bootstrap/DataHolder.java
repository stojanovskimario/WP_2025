package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();

    private final AuthorRepository authorRepository;

    public DataHolder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void data() {
        List<Author> authors = authorRepository.findAll();
        for (int i = 0 ; i < 10 ; i++) {
            Author author = authors.get(i % authors.size());
            books.add(new Book("Book " + i,"Genre " + i,(double) i/2,author));
        }
    }
}