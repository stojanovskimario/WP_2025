package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

//    @GetMapping("/books/add")
//    public String getAddBook(Model model) {
//        model.addAttribute("authors", authorService.findAll());
//        return "addBook";
//    }

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        List<Book> books = bookService.listAll();
        model.addAttribute("books", books);

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "listBooks";
    }

    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = authorService.findAll()
                .stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);

        if (author != null) {
            bookService.save(title, genre, averageRating, author);
        }

        return "redirect:/books";
    }

    @PostMapping("/books/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        Author author = authorService.findAll()
                .stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);

        if (author != null) {
            bookService.edit(bookId, title, genre, averageRating, author);
        }

        return "redirect:/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }

//    @GetMapping("/books/form")
//    public String getBookForm(Model model) {
//        model.addAttribute("book", new Book()); // empty book for new
//        model.addAttribute("authors", authorService.findAll());
//        model.addAttribute("formAction", "/books/add"); // form submits here
//        return "book-form";
//    }

    @GetMapping("/books/book-form/{bookId}")
    public String getEditBookForm(@PathVariable Long bookId, Model model) {
        Book book = bookService.listAll()
                .stream()
                .filter(b -> b.getId()==(bookId))
                .findFirst()
                .orElse(null);

        if (book == null) {
            return "redirect:/books?error=BookNotFound";
        }

        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("formAction", "/books/edit/" + bookId);
        return "book-form";
    }

//    @GetMapping("/books/book-form/{id}")
//    public String getEditBookFormExisting(@PathVariable Long id, Model model) {
//
//        Book book = bookService.listAll()
//                .stream()
//                .filter(b -> b.getId()==(id))
//                .findFirst()
//                .orElse(null);
//
//        // If book not found, redirect with error
//        if (book == null) {
//            return "redirect:/books?error=BookNotFound";
//        }
//
//
//        model.addAttribute("book", book);
//        model.addAttribute("authors", authorService.findAll());
//        return "book-form"; // show book-form.html
//    }

    @GetMapping("/books/book-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("book", new Book());
        model.addAttribute("formAction", "/books/add");
        return "book-form";
    }
}