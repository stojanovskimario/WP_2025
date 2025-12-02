//package mk.ukim.finki.wp.lab.web;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import mk.ukim.finki.wp.lab.service.BookService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "BookListServlet")
//@RequiredArgsConstructor
//public class BookListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final BookService bookService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        String text = req.getParameter("text");
//        String rating = req.getParameter("rating");
//
//        if(text != null && rating != null) {
//            context.setVariable("books", bookService.searchBooks(text, Double.parseDouble(rating)));
//        } else {
//            context.setVariable("books", bookService.listAll());
//        }
//
//        springTemplateEngine.process("listBooks.html", context, resp.getWriter());
//    }
//}
