package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookReservationController {

    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping("/bookReservation")
    public String placeReservation(@RequestParam String bookTitle,
                                   @RequestParam String readerName,
                                   @RequestParam String readerAddress,
                                   @RequestParam int numCopies,
                                   HttpServletRequest request,
                                   Model model) {

        // Get client IP
        String ipAddress = request.getRemoteAddr();

        // Place the reservation via service
        bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);

        // Add variables to the model to be displayed in reservationConfirmation.html
        model.addAttribute("bookTitle", bookTitle);
        model.addAttribute("readerName", readerName);
        model.addAttribute("readerAddress", readerAddress);
        model.addAttribute("numCopies", numCopies);
        model.addAttribute("ipAddress", ipAddress);

        // Return Thymeleaf template name
        return "reservationConfirmation";
    }
}
