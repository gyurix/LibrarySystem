package gyurix.librarysystem.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import gyurix.librarysystem.services.user.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class LoggedUser {
    public static final String LOGGED_USER_ATTRIB = "LOGGED_USER";
}
