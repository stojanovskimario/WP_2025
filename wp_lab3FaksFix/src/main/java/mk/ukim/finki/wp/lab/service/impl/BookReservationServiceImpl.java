package mk.ukim.finki.wp.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service

public class BookReservationServiceImpl implements BookReservationService {

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    private final BookReservationRepository bookReservationRepository;

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        BookReservation bookReservation = new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies);
        return bookReservationRepository.save(bookReservation);
    }
}
