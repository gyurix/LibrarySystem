package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.book.Book;
import gyurix.librarysystem.services.comment.Comment;
import gyurix.librarysystem.services.comment.Komentar;
import gyurix.librarysystem.services.explicit_terms.ExplicitTerms;
import gyurix.librarysystem.services.explicit_terms.Explicittermss;
import gyurix.librarysystem.services.user.Users;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

import static gyurix.librarysystem.controllers.LoginController.LOGIN_HTML;

@Controller
public class CommentsController {
    private static final String HTML = "comments";
    private static final String PATH = "/comments";
    private static final String PATH_ADD = "/postComment";

    private boolean message = false;

    @RequestMapping(value = PATH, method = RequestMethod.GET)
    public String getComments(Model model, HttpSession session, @RequestParam(value = "bookId", defaultValue = "own") String bookId) {
        session.setAttribute("bookId", bookId);
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
            return LOGIN_HTML;
        }
        Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
        if (!message)
            model.addAttribute("message", "Pridať komentár");
        else model.addAttribute("message", "Komentár porušuje pravidlá");
        if (bookId.equals("own")) {
            model.addAttribute("title", "Vlastné komentáre");
            int userId = loggedUser.getId();
            List<Comment> commentList = SOAPConnector.instance.getCommentsByUser(userId);
            model.addAttribute("commentList", commentList);
        } else {
            Book book = SOAPConnector.instance.getBookById(Integer.parseInt(bookId));
            model.addAttribute("title", "Komentáre o knihe " + book.getName());
            List<Comment> commentList = SOAPConnector.instance.getCommentsByBook(Integer.parseInt(bookId));
            model.addAttribute("commentList", commentList);
        }
        return HTML;
    }

    @SneakyThrows
    public XMLGregorianCalendar getNow() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        return datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
    }

    @RequestMapping(value = PATH_ADD, method = RequestMethod.POST)
    public String postComment(Model model, HttpSession session, @ModelAttribute("comment") Komentar comment) {
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
            return LOGIN_HTML;
        }
        List<String> explicitTerms = SOAPConnector.instance.getAllExplicitTerms();
        try {
            Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
            String commentText = comment.getText().toLowerCase();
            message = false;
            if (loggedUser.getType() == 1) {
                for (String s : explicitTerms) {
                    if (commentText.contains(s)) {
                        message = true;
                        break;
                    }
                }
            }
            if (!message) {
                comment.setAccepted(false);
                comment.setAcceptedDate(getNow());
                comment.setAddedDate(getNow());
                comment.setName("N/A");
                comment.setBookId(Integer.parseInt((String) session.getAttribute("bookId")));
                comment.setReviewerNote("N/A");
                comment.setUserID(loggedUser.getId());
                SOAPConnector.instance.insertComment(comment);
            }
        } catch (Throwable ignored) {
        }
        return getComments(model, session, (String) session.getAttribute("bookId"));
    }
}
