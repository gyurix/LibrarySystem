package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.Book;
import gyurix.librarysystem.models.BookList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {
    private static final String BOOK_LIST_PATH = "/bookList";
    private static final String BOOK_LIST_HTML = "bookList";

    @RequestMapping(BOOK_LIST_PATH)
    public String getBookList(Model model, HttpSession session) {
        List<Book> bookList = (List<Book>)session.getAttribute("BOOKLIST");

        model.addAttribute("bookList", bookList);
        return BOOK_LIST_HTML;
    }
}
