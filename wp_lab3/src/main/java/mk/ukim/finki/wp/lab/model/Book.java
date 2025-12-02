package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String genre;

    private double averageRating;

    @ManyToOne
    private Author author;


    protected Book() {}

    public Book(String title, String genre, double averageRating, Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

    public Book(Long id, String title, String genre, double averageRating, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
    }

}
