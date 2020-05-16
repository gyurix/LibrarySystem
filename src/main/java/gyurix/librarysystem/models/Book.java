package gyurix.librarysystem.models;

import lombok.Data;

@Data
public class Book {
  protected String author;
  protected String title;
  protected String commentLink;
  protected String publisher;
  protected String ISBN;
  protected String pictureLink;
  protected int year;
  protected int id;

  public Book(int id, String title, String author, int year, String publisher, String ISBN, String pictureLink) {
    this.id = id;
    this.title = title;
    this.commentLink = "/comments?bookId=" + Integer.toString(id);
    this.author = author;
    this.year = year;
    this.publisher = publisher;
    this.ISBN = ISBN;
    this.pictureLink = pictureLink;
  }

  public void setId(int id) {
    this.id = id;
    this.commentLink = "/comments?bookId=" + Integer.toString(id);
  }

  public void setCommentLink(String commentLink) {
    this.commentLink = commentLink;
  }

  public void setPictureLink(String pictureLink) {
    this.pictureLink = pictureLink;
  }
}
