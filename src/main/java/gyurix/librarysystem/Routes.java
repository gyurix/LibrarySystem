package gyurix.librarysystem;

import gyurix.librarysystem.packets.in.Login;
import gyurix.librarysystem.packets.out.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Routes {
  @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
  public LoginResponse login(@RequestBody Login login) {
    return new LoginResponse(true, "Succesfully Logged In, Welcome " + login.getEmail());
  }
}
