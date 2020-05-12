package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.user.User;
import gyurix.librarysystem.services.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    public static final String INDEX_HTML = "index.html";
    public static final String INDEX_PATH = "/";

    @RequestMapping(INDEX_PATH)
    public String index(HttpSession session, Model model) {
        if (session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB) != null) {
            Users loggedUser = (Users) session.getAttribute(LoggedUser.LOGGED_USER_ATTRIB);
            model.addAttribute("welcomeHeader", "Vitaj " + loggedUser.getName() + "!");
            model.addAttribute("titleSubheader", "Bol si prihlásený do informačného systému");
            model.addAttribute("buttonText", "Prejsť na komentáre");
            model.addAttribute("loginButton", "Odhlásiť sa");
            model.addAttribute("loginPath", "https://google.com/");
        }
        else {
            model.addAttribute("welcomeHeader", "Informačný systém knižnice");
            model.addAttribute("titleSubheader", "Pre vstup do knižnice kliknite na tlačidlo Prihlásiť sa");
            model.addAttribute("buttonText", "Prihlásiť sa");
            model.addAttribute("loginButton", "Prihlásiť sa");
            model.addAttribute("loginPath", "/login");
        }

        return INDEX_HTML;
    }
}
