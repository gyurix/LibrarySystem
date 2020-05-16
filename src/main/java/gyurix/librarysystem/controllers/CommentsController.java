package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentsController {
  private static final String HTML = "comments";
  private static final String PATH = "/comments";

  @RequestMapping(PATH)
  public String getComments(Model model, HttpSession session) {
    if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
      model.addAttribute("loginButton", "Odhlásiť sa");
      model.addAttribute("loginPath", "/logout");
    } else {
      model.addAttribute("loginButton", "Prihlásiť sa");
      model.addAttribute("loginPath", "/login");
    }
    Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
    int userId = loggedUser.getId();
    SOAPConnector.instance.getCommentsByUser(userId);

    return HTML;
  }
}
