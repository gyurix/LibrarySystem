package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.SignupFormModel;
import gyurix.librarysystem.services.user.User;
import gyurix.librarysystem.services.validator.ValidateEmailResponse;
import gyurix.librarysystem.tools.PasswordManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {
  private static final String SIGNUP_ADMIN_PATH = "/signupAdmin";
  private static final String SIGNUP_HTML = "signup.html";
  private static final String SIGNUP_PATH = "/signup";
  private static final String SIGNUP_REVIEWER_PATH = "/signupReviewer";

  public boolean passwordMatch(String passwd1, String passwd2) {
    return passwd1.equals(passwd2);
  }

  @PostMapping(SIGNUP_PATH)
  public String postSignup(@ModelAttribute(SignupFormModel.FORM_ATTRIB) SignupFormModel model, Model model2) {
    String email = model.getEmail();
    String password = model.getPassword();
    String passwordCheck = model.getPasswordCheck();
    String name = model.getName();
    String lastname = model.getLastname();

    boolean isEmail = SOAPConnector.instance.validateEmail(email).isSuccess();

    if (
      isEmail &&
        !password.isEmpty() &&
        !passwordCheck.isEmpty() &&
        !name.isEmpty() &&
        !lastname.isEmpty()) {
      if (passwordMatch(password, passwordCheck)) {
        PasswordManager passwordManager = PasswordManager.getInstance();
        byte[] passwordHash = passwordManager.getPasswordHash(password);
        String passwordHashString = passwordManager.hashToString(passwordHash);

        User user = new User();
        user.setEmail(email);
        user.setType(1);
        user.setPasswordHash(passwordHashString);
        user.setName(name + " " + lastname);

        SOAPConnector.instance.insertUser(user);
        SOAPConnector.instance.sendSignupMessage(user);

        model2.addAttribute(MessageController.TITLE_HEADER, "Registrácia prebehla úspešne");
        model2.addAttribute(MessageController.MESSAGE_HEADER, "Používateľ " + email + " bol úspešne zaregistrovaný! Môžete sa prihlásiť. ");
        return MessageController.MESSAGE_HTML;
      }
    }

    return SIGNUP_PATH;
  }

  @RequestMapping(SIGNUP_PATH)
  public String signup(Model model) {
    return SIGNUP_HTML;
  }
}
