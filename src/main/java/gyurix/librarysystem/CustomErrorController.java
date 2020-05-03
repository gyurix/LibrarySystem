package gyurix.librarysystem;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    public static final String ERROR_PATH = "/error";
    public static final String ERROR_HTML = "error.html";

    @RequestMapping(ERROR_PATH)
    public String error() {
        return ERROR_HTML;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
