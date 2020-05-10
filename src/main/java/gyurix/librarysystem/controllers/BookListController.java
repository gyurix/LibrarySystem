package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.Book;
import gyurix.librarysystem.models.BookList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {
    private static final String BOOK_LIST_PATH = "/bookList";
    private static final String BOOK_LIST_HTML = "bookList";

    @RequestMapping(BOOK_LIST_PATH)
    public String getBookList(Model model) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Kniha1", "Autor1", 2001));
        bookList.add(new Book("Kniha2", "Autor2", 2002));
        bookList.add(new Book("Kniha3", "Autor3", 2003));

        model.addAttribute("bookList", bookList);
        return BOOK_LIST_HTML;
    }
}
