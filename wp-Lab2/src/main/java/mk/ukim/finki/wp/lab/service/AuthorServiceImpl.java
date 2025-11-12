package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Long id, String name, String surname, String country, String biography) {
        Author author = new Author(id, name, surname, country, biography);
        return authorRepository.save(author);
    }

    @Override
    public Author edit(Long id, String name, String surname, String country, String biography) {
        Optional<Author> existingAuthorOpt = authorRepository.findById(id);
        if (existingAuthorOpt.isPresent()) {
            Author author = existingAuthorOpt.get();
            author.setName(name);
            author.setSurname(surname);
            author.setCountry(country);
            author.setBiography(biography);
            return author;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        authorRepository.delete(id);
    }
}
