package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.ResetPasswordModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResetPasswordController {
    private static final String RESET_PATH = "/resetPassword";
    private static final String SUBMIT_RESET_PATH = "/submitResetPassword";
    private static final String RESET_HTML = "resetPassword";
    private static final String RESET_MESSAGE_HTML = "resetMessage";
    private static final String EMAIL_ATTRIBUTE = "email";

    @RequestMapping(RESET_PATH)
    public String resetPassword(Model model) {
        model.addAttribute(EMAIL_ATTRIBUTE);
        return RESET_HTML;
    }

    @PostMapping(RESET_HTML)
    public String submitResetPassword(@ModelAttribute(ResetPasswordModel.RESET_PASSWORD_ATTRIBUTE) ResetPasswordModel model, Model mod) {
        String email = model.getEmail();
        mod.addAttribute(EMAIL_ATTRIBUTE, email);
        return RESET_MESSAGE_HTML;
    }

}
