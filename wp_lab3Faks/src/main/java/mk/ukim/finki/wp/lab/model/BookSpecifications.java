package mk.ukim.finki.wp.lab.model;

import org.springframework.data.jpa.domain.Specification;
import mk.ukim.finki.wp.lab.model.Book;

public class BookSpecifications {

    public static Specification<Book> titleContains(String keyword) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<Book> averageRatingGreaterThan(double rating) {
        return (root, query, cb) -> cb.greaterThan(root.get("averageRating"), rating);
    }

    public static Specification<Book> hasAuthor(Long authorId) {
        return (root, query, cb) -> cb.equal(root.get("author").get("id"), authorId);
    }
}
