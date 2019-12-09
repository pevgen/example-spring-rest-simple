package ml.pevgen.example.springrestsimple.mapper;

import ml.pevgen.example.springrestsimple.domain.Author;
import ml.pevgen.example.springrestsimple.dto.AuthorDto;
import ml.pevgen.example.springrestsimple.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

    Author toEntity(BookDto bookDto);

    List<Author> toEntityList(List<AuthorDto> authorDtoList);

}