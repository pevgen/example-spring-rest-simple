package ml.pevgen.example.springrestsimple.web;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public Page<BookDto> findAll(Pageable pageable) {
        return this.bookService.findAll(pageable);
    }


    @GetMapping(value = "/books/{bookId}")
    public BookDto findById(@PathVariable("bookId") Long bookId) {

        return this.bookService.findById(bookId);
    }


    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}