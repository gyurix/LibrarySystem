package gyurix.librarysystem.models;

public class SignupFormModel {
  public static final String FORM_ATTRIB = "signupForm";

  protected String email;
  protected String lastname;
  protected String name;
  protected String password;
  protected String passwordCheck;

  public SignupFormModel(String email, String password, String passwordCheck, String name, String lastname) {
    this.email = email;
    this.password = password;
    this.passwordCheck = passwordCheck;
    this.name = name;
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
