package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
  public static final String LOGOUT_HTML = "message.html";
  public static final String LOGOUT_PATH = "/logout";

  @RequestMapping(LOGOUT_PATH)
  public String logout(HttpSession session, Model model) {
    session.setAttribute(LoggedUser.LOGGED_USER_ATTRIB, null);

    model.addAttribute(MessageController.TITLE_HEADER, "Boli ste odhlásený");
    model.addAttribute(MessageController.MESSAGE_HEADER, "Môžete sa znovu prihlásiť.");

    return LOGOUT_HTML;
  }
}
