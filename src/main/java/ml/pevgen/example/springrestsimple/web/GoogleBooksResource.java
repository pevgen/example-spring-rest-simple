package ml.pevgen.example.springrestsimple.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.service.GoogleBooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "googleBooks")
@RequestMapping(GoogleBooksResource.RESOURCE_URI_GOOGLE_BOOKS)
public class GoogleBooksResource {

    static final String RESOURCE_URI_GOOGLE_BOOKS = "/googleBooks";

    private GoogleBooksService googleBooksService;

    public GoogleBooksResource(GoogleBooksService googleBooksService) {
        this.googleBooksService = googleBooksService;
    }

    @GetMapping
    @ApiOperation(value = "Search book by ISDN in GoogleBooks", notes = "Notes for the operation")
    public BookDto findAll(String isbn) {
        return this.googleBooksService.findBookByISBN(isbn);
    }

}
