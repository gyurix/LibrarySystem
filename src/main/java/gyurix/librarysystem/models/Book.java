package gyurix.librarysystem.models;

import lombok.Data;

@Data
public class Book {
  protected String author;
  protected String title;
  protected String commentLink;
  protected int year;
  protected String id;

  public Book(String title, String author, int year) {
    this.title = title;
    this.commentLink = "/comments?bookId=1";
    this.author = author;
    this.year = year;
  }
}
