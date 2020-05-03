package gyurix.librarysystem.controllers;

import gyurix.librarysystem.models.User;
import gyurix.librarysystem.services.user.GetByIdResponse;
import gyurix.librarysystem.services.user.InsertResponse;
import gyurix.librarysystem.services.user.UserClient;
import gyurix.librarysystem.tools.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    public static final String LOGIN_PATH = "/login";
    public static final String LOGIN_HTML = "login.html";

    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "password";

    @Autowired
    private UserClient userClient;

    @RequestMapping(LOGIN_PATH)
    public String getLoginSite(Model model) {
        User user = new User();
        model.addAttribute(EMAIL_INPUT_ID, user);
        model.addAttribute(PASSWORD_INPUT_ID, user);
        return LOGIN_HTML;
    }

    @PostMapping(LOGIN_PATH)
    public String signIn(@ModelAttribute(User.USER_MODEL_ATTRIBUTE) User user) {
        PasswordManager passwordManager = PasswordManager.getInstance();
        byte[] passwordHash = passwordManager.getPasswordHash(user.getPassword());
        String passwordHashString = passwordManager.hashToString(passwordHash);
        user.setPasswordHash(passwordHashString);

        GetByIdResponse response = userClient.getUser(1);
        System.out.println(response.getUser());

        return LOGIN_HTML;
    }


}
