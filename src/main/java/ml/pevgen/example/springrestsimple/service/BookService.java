package ml.pevgen.example.springrestsimple.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.domain.Book;
import ml.pevgen.example.springrestsimple.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }
}
