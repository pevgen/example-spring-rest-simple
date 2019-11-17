package ml.pevgen.example.springrestsimple.controller;

import ml.pevgen.example.springrestsimple.model.Book;
import ml.pevgen.example.springrestsimple.repository.LibRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibController {

    private LibRepository libRepository;

    public LibController(LibRepository libRepository) {
        this.libRepository = libRepository;
    }

    @GetMapping(value = "/books")
    public List<Book> getBooks(){
        return this.libRepository.getBooks();
    }

    @GetMapping("/test")
    public String homePage() {
        return "home";
    }
}
