package gyurix.librarysystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarySystem {
  public static void main(String[] args) {
    SpringApplication.run(LibrarySystem.class, args);
  }

//  @Bean
//  CommandLineRunner lookup(SOAPConnector connector) {
//    return args -> {
//      System.out.println("Loaded, response = " + SOAPConnector.instance.getAll());
//    };
//  }
}
