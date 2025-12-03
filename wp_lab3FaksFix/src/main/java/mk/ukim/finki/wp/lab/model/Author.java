package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String country;

    private String biography;

    @OneToMany(mappedBy = "author")
    private List<Book> book = new ArrayList<>();

    protected Author() {}

    public Author(String name, String surname, String country, String biography) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }

    public Author(Long id, String name, String surname, String country, String biography, List<Book> book) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
        this.book = book;
    }

}
