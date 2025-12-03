package mk.ukim.finki.wp.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorServiceImpl implements AuthorService {

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        List<Author> authors = findAll();

        for(Author author : authors){
            if(author.getId().equals(id)){
                return author;
            }
        }

        return null;
    }
}
