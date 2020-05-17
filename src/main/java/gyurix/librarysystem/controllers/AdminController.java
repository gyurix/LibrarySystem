package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.comment.Comment;
import gyurix.librarysystem.services.comment.Komentar;
import gyurix.librarysystem.services.user.Users;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

import static gyurix.librarysystem.controllers.LoginController.LOGIN_HTML;
import static java.lang.Boolean.TRUE;

@Controller
public class AdminController {
    private static final String UNSOLVED_COMMENTS_LIST_HTML = "unsolvedComments";
    private static final String UNSOLVED_COMMENTS_PATH = "/unsolvedComments";
    private static final String PATH_CONFIRM = "/confirmComment";

    @RequestMapping(value = UNSOLVED_COMMENTS_PATH, method = RequestMethod.GET)
    public String getUnsolvedComments(Model model, HttpSession session) {
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
            return LOGIN_HTML;
        }

            List<Comment> commentList = SOAPConnector.instance.getUnsolvedComments();
            model.addAttribute("commentList", commentList);


        return UNSOLVED_COMMENTS_LIST_HTML;
    }

    @SneakyThrows
    public XMLGregorianCalendar getNow() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        return datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
    }

    @RequestMapping(value = PATH_CONFIRM, method  = RequestMethod.POST )
    public String confirmComment(Model model, HttpSession session, @ModelAttribute("comment.id") int commentId) {

        System.out.println(commentId);

        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
            return LOGIN_HTML;
        }


        Comment comment = SOAPConnector.instance.getCommentById(commentId);
        Komentar komentar = new Komentar();
        komentar.setAccepted(true);
        komentar.setAcceptedDate(getNow());
        komentar.setAddedDate(comment.getAddedDate());
        komentar.setBookId(comment.getBookId());
        komentar.setUserID(comment.getUserID());
        komentar.setId(commentId);
        komentar.setRating(comment.getRating());
        komentar.setText(comment.getText());
        komentar.setSpoiler(comment.isSpoiler());

        SOAPConnector.instance.updateComment(komentar,commentId);

        return UNSOLVED_COMMENTS_LIST_HTML;
    }
}