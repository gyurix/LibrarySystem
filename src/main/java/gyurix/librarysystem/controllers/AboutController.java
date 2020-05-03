package gyurix.librarysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
    public static final String ABOUT_PATH = "/about";
    public static final String ABOUT_HTML = "about.html";

    @RequestMapping(ABOUT_PATH)
    public String about() {
        return ABOUT_HTML;
    }
}
