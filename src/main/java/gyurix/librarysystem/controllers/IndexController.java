package gyurix.librarysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    public static final String INDEX_PATH = "/";
    public static final String INDEX_HTML = "index.html";

    @RequestMapping(INDEX_PATH)
    public String index() {
        return INDEX_HTML;
    }
}
