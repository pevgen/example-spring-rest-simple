package ml.pevgen.example.springrestsimple.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.repository.remote.GoogleBooksClient;
import ml.pevgen.example.springrestsimple.repository.remote.Results;
import ml.pevgen.example.springrestsimple.web.error.BookNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class GoogleBooksService {

    private GoogleBooksClient googleBooksClient;

    public GoogleBooksService(GoogleBooksClient googleBooksClient) {
        this.googleBooksClient = googleBooksClient;
    }

    public BookDto findBookByISBN(String isbn) {
        Results result = googleBooksClient.findBookByQuery("isbn:" + isbn);

        validateQueryResult(isbn, result);

        BookDto dto = new BookDto();
        dto.setIsbn(isbn);
        dto.setTitle(result.getItems().get(0).getVolumeInfo().getTitle());
        return dto;

    }

    private void validateQueryResult(String isbn, Results result) {
        if (CollectionUtils.isEmpty(result.getItems())) {
            throw new BookNotFoundException("Book with ISBN:" + isbn + " not found");
        }
    }
}
