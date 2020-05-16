package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.book.Book;
import gyurix.librarysystem.services.comment.Comment;
import gyurix.librarysystem.services.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static gyurix.librarysystem.controllers.LoginController.LOGIN_HTML;

@Controller
public class CommentsController {
  private static final String HTML = "comments";
  private static final String PATH_USER = "/comments";

  @RequestMapping(PATH_USER)
  public String getComments(Model model, HttpSession session, @RequestParam(value = "bookId", defaultValue = "own") String bookId) {
    if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
      model.addAttribute("loginButton", "Odhlásiť sa");
      model.addAttribute("loginPath", "/logout");
    } else {
      model.addAttribute("loginButton", "Prihlásiť sa");
      model.addAttribute("loginPath", "/login");
      return LOGIN_HTML;
    }
    Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
    if (bookId.equals("own")) {
      model.addAttribute("title", "Vlastné komentáre");
      int userId = loggedUser.getId();
      List<Comment> commentList = SOAPConnector.instance.getCommentsByUser(userId);
      model.addAttribute("commentList", commentList);
    } else {
      Book book = SOAPConnector.instance.getBookById(Integer.parseInt(bookId));
      model.addAttribute("title", book.getName() + " - Komentáre");
      List<Comment> commentList = SOAPConnector.instance.getCommentsByBook(book.getId());
      model.addAttribute("commentList", commentList);
    }
    return HTML;
  }
}
