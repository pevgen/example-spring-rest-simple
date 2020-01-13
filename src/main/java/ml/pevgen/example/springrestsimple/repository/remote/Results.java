package ml.pevgen.example.springrestsimple.repository.remote;

import lombok.Getter;

import java.util.List;

@Getter
public class Results {

    private int totalItems;
    private List<Item> items;

}
