package mk.ukim.finki.wp.lab.web.controller;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, @RequestParam(required = false) Long authorId, Model model) {
        model.addAttribute("authors", authorService.findAll());

        if(authorId == null) {
            model.addAttribute("books", bookService.listAll());
        } else {
            model.addAttribute("books", bookService.listAllByAuthorId(authorId));
        }

        return "listBooks";
    }

    @GetMapping("/books/book-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/books/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if(book == null) {
            return "redirect:/books?error=BookNotFound";
        } else {
            model.addAttribute("book", book);
            model.addAttribute("authors", authorService.findAll());
            return "book-form";
        }
    }

    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        bookService.addBook(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/books/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        bookService.editBook(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
