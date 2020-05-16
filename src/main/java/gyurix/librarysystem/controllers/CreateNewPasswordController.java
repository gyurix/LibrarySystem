package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.CreateNewPasswordForm;
import gyurix.librarysystem.services.user.User;
import gyurix.librarysystem.tools.PasswordManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateNewPasswordController {
  public static final String CREATE_NEW_PASSWORD_HTML = "createNewPassword.html";
  public static final String CREATE_NEW_PASSWORD_PATH = "/createNewPassword";

  private String userId;

  @RequestMapping(CREATE_NEW_PASSWORD_PATH)
  public String createNewPassword(Model model, @RequestParam String user_id) {
    userId = user_id;

    return CREATE_NEW_PASSWORD_HTML;
  }

  @PostMapping(CREATE_NEW_PASSWORD_PATH)
  public String postCreateNewPassword(@ModelAttribute(CreateNewPasswordForm.CREATE_NEW_PASSWORD_FORM_ATTRIB) CreateNewPasswordForm form, Model model) {
    String password = form.getPassword();
    String passwordCheck = form.getPasswordCheck();

    if (password.equals(passwordCheck)) {
      User user = SOAPConnector.instance.getUserById(Integer.parseInt(userId)).getUser();

      if (user.getEmail() == null)
        return CustomErrorController.ERROR_HTML;
      // GENERATE NEW PASSWORD HASH
      PasswordManager passwordManager = PasswordManager.getInstance();
      byte[] passwordHash = passwordManager.getPasswordHash(password);
      String passwordHashString = passwordManager.hashToString(passwordHash);

      user.setPasswordHash(passwordHashString);
      SOAPConnector.instance.recoverPassword(user);

      model.addAttribute(MessageController.TITLE_HEADER, "Heslo bolo obnovené");
      model.addAttribute(MessageController.MESSAGE_HEADER, "Teraz sa môžete prihlásiť s novým heslom.");
      return MessageController.MESSAGE_HTML;
    }

    return CREATE_NEW_PASSWORD_HTML;
  }

}
