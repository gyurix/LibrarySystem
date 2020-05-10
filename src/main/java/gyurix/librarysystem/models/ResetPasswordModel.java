package gyurix.librarysystem.models;

public class ResetPasswordModel {
    public static final String RESET_PASSWORD_ATTRIBUTE = "reset_password_email";
    protected String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
