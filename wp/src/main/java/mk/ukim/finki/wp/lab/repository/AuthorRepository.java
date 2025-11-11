package mk.ukim.finki.wp.lab.repository;

import lombok.Data;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
}
