package gyurix.librarysystem.packets.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
  private boolean result;
  private String message;
}
