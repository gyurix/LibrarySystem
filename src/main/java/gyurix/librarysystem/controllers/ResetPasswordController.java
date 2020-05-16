package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.ResetPasswordModel;
import gyurix.librarysystem.services.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ResetPasswordController {
  private static final String EMAIL_ATTRIBUTE = "email";
  private static final String RESET_HTML = "resetPassword";
  private static final String RESET_MESSAGE_HTML = "resetMessage";
  private static final String RESET_PATH = "/resetPassword";
  private static final String SUBMIT_RESET_PATH = "/submitResetPassword";

  @RequestMapping(RESET_PATH)
  public String resetPassword(Model model) {
    return RESET_HTML;
  }

  @PostMapping(RESET_PATH)
  public String submitResetPassword(@ModelAttribute(ResetPasswordModel.RESET_PASSWORD_ATTRIBUTE) ResetPasswordModel model, Model mod) {
    String email = model.getEmail();
    if (email.isEmpty())
      return RESET_HTML;

    List<Users> user = SOAPConnector.instance.getUser(email).getUsers().getUser();
    for (Users u : user) {
      SOAPConnector.instance.sendPasswordRecoveryNotify(u);
    }


    mod.addAttribute(EMAIL_ATTRIBUTE, email);
    return RESET_MESSAGE_HTML;
  }

}
