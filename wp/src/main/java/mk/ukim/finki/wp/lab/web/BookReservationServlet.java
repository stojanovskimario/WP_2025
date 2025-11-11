//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.BookReservationService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "BookReservationServlet", urlPatterns = { "/bookReservation"})
//public class BookReservationServlet extends HttpServlet {
//
//    private final BookReservationService bookReservationService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public BookReservationServlet(BookReservationService bookReservationService, SpringTemplateEngine springTemplateEngine) {
//        this.bookReservationService = bookReservationService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//
//        String bookTitle = req.getParameter("bookTitle");
//        String readerName = req.getParameter("readerName");
//        String readerAddress = req.getParameter("readerAddress");
//        int numCopies = Integer.parseInt(req.getParameter("numCopies"));
//
//        String ip = req.getRemoteAddr();
//
//        context.setVariable("readerName", readerName);
//        context.setVariable("ipAddress", ip);
//        context.setVariable("bookTitle", bookTitle);
//        context.setVariable("numCopies", numCopies);
//
//        bookReservationService.placeReservation(bookTitle,readerName,readerAddress,numCopies);
//
//        springTemplateEngine.process("reservationConfirmation.html", context, resp.getWriter());
//    }
//
//}
