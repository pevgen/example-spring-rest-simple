package ml.pevgen.example.springrestsimple.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    @ManyToOne
    private Book book;
}
