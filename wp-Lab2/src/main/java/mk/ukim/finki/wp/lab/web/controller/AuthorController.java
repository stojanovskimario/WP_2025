package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    
    @GetMapping("/authors")
    public String getAuthorsPage(@RequestParam(required = false) String error, Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "listAuthors";
    }


    @PostMapping("/authors/add")
    public String saveAuthor(
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String country,
                             @RequestParam String biography) {
        List<Author> authors = authorService.findAll();
        Long id = authors.isEmpty() ? 1L : authors.stream()
                .mapToLong(Author::getId)
                .max()
                .orElse(0L) + 1;
        Author author = authorService.save(id, name, surname, country, biography);
        return "redirect:/authors";
    }


    @PostMapping("/authors/edit/{id}")
    public String editAuthor(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String country,
                             @RequestParam String biography) {
        Author author = authorService.edit(id, name, surname, country, biography);
        if (author == null) {
            return "redirect:/authors?error=AuthorNotFound";
        }
        return "redirect:/authors";
    }


    @PostMapping("/authors/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }


    @GetMapping("/authors/author-form")
    public String getAddAuthorPage(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("formAction", "/authors/add");
        return "author-form";
    }


    @GetMapping("/authors/author-form/{authorId}")
    public String getEditAuthorForm(@PathVariable Long authorId, Model model) {
        Author author = authorService.findAll().stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);

        if (author == null) {
            return "redirect:/authors?error=AuthorNotFound";
        }

        model.addAttribute("author", author);
        model.addAttribute("formAction", "/authors/edit/" + authorId);
        return "author-form";
    }
}
