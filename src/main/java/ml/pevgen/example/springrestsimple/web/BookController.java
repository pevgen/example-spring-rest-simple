package ml.pevgen.example.springrestsimple.web;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Page<BookDto> findAll(Pageable pageable) {
        return this.bookService.findAll(pageable);
    }

    @GetMapping(value = "/books/{bookId}")
    public BookDto findById(@PathVariable("bookId") Long bookId) {
        return this.bookService.findById(bookId);
    }

    @PostMapping(value = "/books")
    public BookDto create(@RequestBody BookDto newBookDto) {
        return this.bookService.create(newBookDto);
    }

    @PutMapping(value = "/books")
    public BookDto update(@RequestBody BookDto updatedBookDto) {
        return this.bookService.update(updatedBookDto);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public void deleteById(@PathVariable("bookId") Long bookId) {
        this.bookService.deleteById(bookId);
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}