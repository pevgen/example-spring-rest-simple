package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.model.Book;

import java.util.List;

public interface LibRepository {

  Book findBookById(long id);

  List<Book> getBooks();


}
