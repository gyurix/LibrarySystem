package gyurix.librarysystem.models;

import java.util.ArrayList;
import java.util.List;

public class BookList {
  protected List<Book> bookList;

  public BookList() {
    this.bookList = new ArrayList<>();
  }

  public void addBook(Book book) {
    this.bookList.add(book);
  }

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }
}
