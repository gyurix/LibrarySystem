package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.Book;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {
    private static final String BOOK_LIST_HTML = "bookList";
    private static final String BOOK_LIST_PATH = "/bookList";

    @RequestMapping(BOOK_LIST_PATH)
    public String getBookList(Model model, HttpSession session) {
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
        }
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(5338, "Little Fires Everywhere: A Novel", "Celeste Ng", 2017, "Penguin Books", "B01N4VW75U", "https://m.media-amazon.com/images/I/51Aaysqku4L.jpg"));
        bookList.add(new Book(5339,"American Dirt (Oprah's Book Club): A Novel", "Jeanine Cummings", 2020, "Flatiron Books", "B07QQLCZY1", "https://m.media-amazon.com/images/I/51hwe011M+L.jpg"));
        bookList.add(new Book(5341,"Educated", "Tara Westover", 2018, "Cornerstone Digital", "B07142R12X", "https://m.media-amazon.com/images/I/51uIbg0SS8L.jpg"));
        bookList.add(new Book(5342, "The Dancing Girls", "M. M. Chouinard", 2019, "Bookouture", "B07NRG8PFH", "https://m.media-amazon.com/images/I/51ac1jZrhML.jpg"));
        bookList.add(new Book(5344, "Normal People", "Sally Rooney", 2018, "Faber & Faber", "B07DVT2VZK", "https://m.media-amazon.com/images/I/41tjS2DPOZL.jpg"));
        bookList.add(new Book(5343,"Grown Ups", "Marian Keyes", 2020, "Penguin", "B07QCTWJCK", "https://m.media-amazon.com/images/I/31IWhMTzDWL.jpg"));
        bookList.add(new Book(5345,"The Choice", "Edith Eger", 2017, "Ebury Digital", "B01F1HOB56", "https://m.media-amazon.com/images/I/51kcvXF41LL.jpg"));
        bookList.add(new Book(5346,"A Gentleman in Moscow", "Amor Towles", 2017, "Cornerstone Digital", "B01AYBWPUM", "https://m.media-amazon.com/images/I/51k+lXZyJ6L.jpg"));
        bookList.add(new Book(5347,"Becoming", "Michelle Obama", 2018, "Penguin", "B079Z661B7", "https://m.media-amazon.com/images/I/41w+k8pPngL.jpg"));

        model.addAttribute("bookList", bookList);
        return BOOK_LIST_HTML;
    }
}
