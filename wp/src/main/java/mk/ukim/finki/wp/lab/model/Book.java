package mk.ukim.finki.wp.lab.model;


import lombok.Data;

@Data
public class Book {
    private String title;
    private String genre;
    private double averageRating;
    private long id;
    private static int counter = 0;
    private Author author;

    public Book(String title, String genre, double averageRating,Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.id = counter++;
        this.author = author;
    }

    public Book() {
    }
}