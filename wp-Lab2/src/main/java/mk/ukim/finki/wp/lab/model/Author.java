package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Author {
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;

    public Author(Long id, String name, String surname, String country, String biography) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
    }

    public Author() {
    }
}
