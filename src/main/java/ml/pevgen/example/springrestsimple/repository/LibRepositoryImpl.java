package ml.pevgen.example.springrestsimple.repository;

import ml.pevgen.example.springrestsimple.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibRepositoryImpl implements LibRepository {
    @Override
    public Book findBookById(long id) {
        return new Book();
    }

    @Override
    public List<Book> getBooks() {
        return new ArrayList<>();
    }
}
