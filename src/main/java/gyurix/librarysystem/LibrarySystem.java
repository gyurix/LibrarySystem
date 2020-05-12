package gyurix.librarysystem;


import gyurix.librarysystem.services.user.User;
import gyurix.librarysystem.services.user.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LibrarySystem {
  public static void main(String[] args) {
    SpringApplication.run(LibrarySystem.class, args);
  }
}
