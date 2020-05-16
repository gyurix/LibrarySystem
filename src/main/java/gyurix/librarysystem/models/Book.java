package gyurix.librarysystem.models;

import lombok.Data;

@Data
public class Book {
  protected String author;
  protected String title;
  protected int year;
  protected String id;

  public Book(String title, String author, int year) {
    this.title = "<a href=\"/comments?bookId=1"+"\">" +title+"</a>";
    this.author = author;
    this.year = year;
  }
}
