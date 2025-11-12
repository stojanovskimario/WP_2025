package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author save(Long id, String name, String surname, String country, String biography);

    Author edit(Long id, String name, String surname, String country, String biography);

    void delete(Long id);

    /*
        private Long id;
    private String name;
    private String surname;
    private String country;
    private String biography;
     */
}
