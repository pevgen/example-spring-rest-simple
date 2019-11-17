package ml.pevgen.example.springrestsimple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long id;
    private String ibsn;
    private String title;
    private Author author;

}
