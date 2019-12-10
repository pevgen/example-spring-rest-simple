package ml.pevgen.example.springrestsimple.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;


@RestController
@Slf4j
@Api(value = "books")
@RequestMapping(BookResource.RESOURCE_URI_BOOKS)
public class BookResource {

    static final String RESOURCE_URI_BOOKS = "/books";

    private BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Finds all Books in the library", notes = "Notes for the operation")
    @GetMapping
    public Page<BookDto> findAll(Pageable pageable) {
        return this.bookService.findAll(pageable);
    }

    @ApiOperation(value = "Finds a book by ID")
    @GetMapping(value = "/{bookId}")
    public BookDto findById(@PathVariable("bookId") Long bookId) {
        return this.bookService.findById(bookId);
    }

    @ApiOperation(value = "Create a new book")
    @PostMapping
    public BookDto create(@RequestBody BookDto newBookDto) {
        return this.bookService.create(newBookDto);
    }

    @ApiOperation(value = "Update a book")
    @PutMapping
    public BookDto update(@RequestBody BookDto updatedBookDto) {
        return this.bookService.update(updatedBookDto);
    }

    @ApiOperation(value = "Delete a book by ID")
    @DeleteMapping(value = "/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("bookId") Long bookId) {
        this.bookService.deleteById(bookId);
    }

    @ApiOperation(value = "Test endpoint", notes = "Just for health-check of the resource")
    @GetMapping("/test")
    public String testPage() {
        return String.format("test : %s", Instant.now());
    }
}