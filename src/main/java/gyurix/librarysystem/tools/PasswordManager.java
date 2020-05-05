package gyurix.librarysystem.tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordManager {
  private static PasswordManager instance = null;

  private PasswordManager() {
  }

  public static PasswordManager getInstance() {
    if (instance == null)
      instance = new PasswordManager();
    return instance;
  }

  public byte[] getPasswordHash(String password) {
    MessageDigest digest = null;
    byte[] passwordHash = null;
    try {
      digest = MessageDigest.getInstance("SHA-256");
      passwordHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return passwordHash;
  }

  public String hashToString(byte[] hash) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b : hash)
      stringBuilder.append(Integer.toHexString(Byte.toUnsignedInt(b)));
    return stringBuilder.toString();
  }
}
