//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Book;
//import mk.ukim.finki.wp.lab.repository.BookRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository // imitacija na baza
//public class InMemoryBookRepository implements BookRepository {
//
//    @Override
//    public List<Book> findAll() {
//        return DataHolder.books;
//    }
//
//    @Override
//    public List<Book> searchBooks(String text, Double rating) {
//        // text = mladen, rating = 5
//        List<Book> result = new ArrayList<>();
//
//        for(Book book : DataHolder.books) {
//            if(book.getTitle().contains(text) && book.getAverageRating() >= rating) {
//                result.add(book);
//            }
//        }
//
//        return result;
//    }
//
//    @Override
//    public Book findById(Long id) {
//        for(Book book : DataHolder.books) {
//            if (book.getId().equals(id)) {
//                return book;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Book book) {
//        DataHolder.books.add(book);
//    }
//
//    @Override
//    public void edit(Book book) {
//        deleteById(book.getId());
//        save(book);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        for(Book book : DataHolder.books) {
//            if(book.getId().equals(id)) {
//                DataHolder.books.remove(book);
//                break;
//            }
//        }
//    }
//}
