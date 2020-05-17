package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.models.User;
import gyurix.librarysystem.services.user.Users;
import gyurix.librarysystem.tools.PasswordManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    public static final String LOGIN_HTML = "login.html";
    public static final String LOGIN_PATH = "/login";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "password";

    @RequestMapping(LOGIN_PATH)
    public String getLoginSite(Model model, HttpSession session) {

        return LOGIN_HTML;
    }

    @PostMapping(LOGIN_PATH)
    public String signIn(@ModelAttribute(User.USER_MODEL_ATTRIBUTE) User user, HttpSession session, Model model) {
        PasswordManager passwordManager = PasswordManager.getInstance();
        byte[] passwordHash = passwordManager.getPasswordHash(user.getPassword());
        String passwordHashString = passwordManager.hashToString(passwordHash);

        List<gyurix.librarysystem.services.user.Users> users = SOAPConnector.instance.getUser(user.getEmail()).getUsers().getUser();
        for (Users i : users) {
            if (i.getPasswordHash().equals(passwordHashString)) {
                session.setAttribute(LoggedUser.LOGGED_USER_ATTRIB, i);
                break;
            }
        }

        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
            model.addAttribute("welcomeHeader", "Vitaj " + loggedUser.getName() + "!");
            model.addAttribute("titleSubheader", "Bol si prihlásený do informačného systému");

            if (loggedUser.getType() != User.USER_TYPE.READER.getTypeInt()) {
                model.addAttribute("path", AdminController.UNSOLVED_COMMENTS_PATH);
                model.addAttribute("buttonText", "Prejsť na komentáre");
            } else {
                model.addAttribute("path", BookListController.BOOK_LIST_PATH);
                model.addAttribute("buttonText", "Prejsť do knižnice");
            }
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "/logout");
            return IndexController.INDEX_HTML;
        } else

        return LOGIN_HTML;
    }


}
