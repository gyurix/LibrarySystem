package gyurix.librarysystem.models;

public class CreateNewPasswordForm {
    public static final String CREATE_NEW_PASSWORD_FORM_ATTRIB = "createNewPasswordForm";
    public static final String PASSWORD_ATTRIB = "password";
    public static final String PASSWORD_CHECK_ATTRIB = "passwordCheck";

    protected String password;
    protected String passwordCheck;

    public CreateNewPasswordForm(String password, String passwordCheck) {
        this.password = password;
        this.passwordCheck = passwordCheck;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}
