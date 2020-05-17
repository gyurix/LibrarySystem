package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.comment.Comment;
import gyurix.librarysystem.services.comment.Komentar;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

import static gyurix.librarysystem.controllers.LoginController.LOGIN_HTML;

@Controller
public class AdminController {
    private static final String UNSOLVED_COMMENTS_LIST_HTML = "unsolvedComments";
    public static final String UNSOLVED_COMMENTS_PATH = "/unsolvedComments";
    public static final String PATH_CONFIRM = "/confirmComment";

    List<Comment> commentList;

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

        commentList = SOAPConnector.instance.getUnsolvedComments();
        model.addAttribute("commentList", commentList);


        return UNSOLVED_COMMENTS_LIST_HTML;
    }

    @SneakyThrows
    public XMLGregorianCalendar getNow() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = null;
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        assert datatypeFactory != null;
        return datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
    }

    @RequestMapping(PATH_CONFIRM)
    public String confirmComment(Model model, HttpSession session, @RequestParam(name = "commentId", defaultValue = "-1") String commentId) {
        int id = Integer.parseInt(commentId);

        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
            return LOGIN_HTML;
        }


        Comment comment = SOAPConnector.instance.getCommentById(id);
        Komentar komentar = new Komentar();
        komentar.setAccepted(true);
        komentar.setAcceptedDate(getNow());
        komentar.setAddedDate(comment.getAddedDate());
        komentar.setBookId(comment.getBookId());
        komentar.setUserID(comment.getUserID());
        komentar.setId(id);
        komentar.setRating(comment.getRating());
        komentar.setText(comment.getText());
        komentar.setSpoiler(comment.isSpoiler());

        SOAPConnector.instance.updateComment(komentar, id);

        commentList = SOAPConnector.instance.getUnsolvedComments();
        model.addAttribute("commentList", commentList);
        return UNSOLVED_COMMENTS_LIST_HTML;
    }
}