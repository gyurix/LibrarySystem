package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.user.Users;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CustomErrorController implements ErrorController {
    public static final String ERROR_HTML = "error.html";
    public static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String error(HttpSession session, Model model) {
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
        } else {
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
        }
        return ERROR_HTML;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
