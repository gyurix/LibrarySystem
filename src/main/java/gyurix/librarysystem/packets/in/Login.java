package gyurix.librarysystem.packets.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Login {
  private String email;
  private String password;
}