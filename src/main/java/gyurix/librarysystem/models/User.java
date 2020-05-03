package gyurix.librarysystem.models;

import org.springframework.web.bind.annotation.ModelAttribute;

public class User {
    public static final String USER_MODEL_ATTRIBUTE = "user";

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String passwordHash;
    protected USER_TYPE userType;

    public enum USER_TYPE {
        ADMIN(1),
        READER(2),
        LIBRARIAN(3);

        private int type;

        USER_TYPE(int type) {
            this.type = type;
        }
    }

    @ModelAttribute(value = USER_MODEL_ATTRIBUTE)
    public User newUser() {
        return new User();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public USER_TYPE getUserType() {
        return userType;
    }

    public void setUserType(USER_TYPE userType) {
        this.userType = userType;
    }
}
