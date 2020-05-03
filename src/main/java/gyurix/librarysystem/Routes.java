package gyurix.librarysystem;

import gyurix.librarysystem.packets.in.Login;
import gyurix.librarysystem.packets.out.LoginResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Routes {
    public static final String INDEX_PATH = "/";
    public static final String INDEX_HTML = "index.html";

    public static final String ABOUT_PATH = "/about";
    public static final String ABOUT_HTML = "about.html";

    @RequestMapping(INDEX_PATH)
    public String index() {
        return INDEX_HTML;
    }

    @RequestMapping(ABOUT_PATH)
    public String about() {
        return ABOUT_HTML;
    }
}
