package gyurix.librarysystem.controllers;

import com.fasterxml.jackson.annotation.JacksonInject;
import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.LoggedUser;
import gyurix.librarysystem.services.user.User;
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
