package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/test")
  public String getSite(Model model) {
    model.addAttribute("headerText", "HELLO");
    System.out.println("Loaded, response = " + SOAPConnector.instance.getAll());
    return "about.html";
  }
}
