package ml.pevgen.example.springrestsimple.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authorList;

}
