package mk.ukim.finki.wp.lab.repository;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Repository
public class AuthorRepository {
    List<Author> authors;

    public AuthorRepository() {
        authors = new ArrayList<>();
        authors.add(new Author(1L,"Ivan","Ivanovski","Makedonija","Avtor na Book"));
        authors.add(new Author(2L,"Petar","Petrovski","Makedonija","Avtor na Book"));
        authors.add(new Author(3L,"John","Smith","Amerika","Avtor na Book"));
    }

    public List<Author> findAll() {
        return authors;
    }


    public Author save(Author author) {
        authors.add(author);
        return author;
    }


    public Optional<Author> findById(Long id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst();
    }


    public boolean delete(Long id) {
        return authors.removeIf(author -> author.getId().equals(id));
    }
}