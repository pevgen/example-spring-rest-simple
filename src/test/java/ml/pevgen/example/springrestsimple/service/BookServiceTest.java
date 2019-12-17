package ml.pevgen.example.springrestsimple.service;

import ml.pevgen.example.springrestsimple.domain.Book;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.mapper.BookMapper;
import ml.pevgen.example.springrestsimple.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles({"test"})
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Spy
    private BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    private Book book;
    private long testId = 1L;

    @BeforeEach
    public void beforeEach(){
        book = new Book(testId, "isbn-1", "title-1", Collections.emptyList());
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
    }

    @Test
    void findById() {

        BookDto resultDto = bookService.findById(testId);
        assertThat(resultDto).isNotNull();
        assertThat(resultDto.getId()).isEqualTo(book.getId());
        assertThat(resultDto.getIsbn()).isEqualTo(book.getIsbn());
        assertThat(resultDto.getTitle()).isEqualTo(book.getTitle());
        assertThat(resultDto.getAuthorList()).isNull();
    }

}