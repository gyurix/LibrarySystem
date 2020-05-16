package gyurix.librarysystem.models;

public class Book {
  protected String author;
  protected String title;
  protected int year;

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
