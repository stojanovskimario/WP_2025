package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReservationController {

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    private final BookReservationService bookReservationService;

    @PostMapping("/bookReservation")
    public String addReservation(@RequestParam String bookTitle,
                                 @RequestParam String readerName,
                                 @RequestParam String readerAddress,
                                 @RequestParam Integer numCopies,
                                 Model model,
                                 HttpServletRequest request) {

        BookReservation bookReservation = bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);
        String ipAddress = request.getRemoteAddr();
        model.addAttribute("readerName", readerName);
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("numCopies", numCopies);
        model.addAttribute("bookTitle", bookReservation.getBookTitle());
        return "reservationConfirmation";
    }
}
