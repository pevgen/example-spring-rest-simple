package ml.pevgen.example.springrestsimple.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import ml.pevgen.example.springrestsimple.mapper.BookMapper;
import ml.pevgen.example.springrestsimple.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository,
                       BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Page<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toDto);
    }

    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found")));
    }

    public BookDto create(BookDto newBookDto) {
        if (newBookDto.getId() != null) {
            throw new IllegalArgumentException("New book shouldn't have a value in the field 'Id'");
        }
        return bookMapper.toDto(
                bookRepository.save(
                        bookMapper.toEntity(newBookDto)));
    }

    public BookDto update(BookDto updatedBookDto) {
        if (updatedBookDto.getId() == null) {
            throw new IllegalArgumentException("New book must have a value in the field 'Id'");
        }
        return bookMapper.toDto(
                bookRepository.save(
                        bookMapper.toEntity(updatedBookDto)));
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
