package gyurix.librarysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
  public static final String INDEX_HTML = "index.html";
  public static final String INDEX_PATH = "/";

  @RequestMapping(INDEX_PATH)
  public String index() {
    return INDEX_HTML;
  }
}
