package ml.pevgen.example.springrestsimple.mapper;

import ml.pevgen.example.springrestsimple.domain.Book;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);
    List<BookDto> toDtoList(List<Book> books);

    Book toEntity(BookDto bookDto);
    List<Book> toEntityList(List<BookDto> bookDtoList);



}