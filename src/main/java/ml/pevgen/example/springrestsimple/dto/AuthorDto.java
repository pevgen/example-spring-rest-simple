package ml.pevgen.example.springrestsimple.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private BookDto book;
}
