package ml.pevgen.example.springrestsimple.repository.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleBooksClient", url = "https://www.googleapis.com/")
public interface GoogleBooksClient {

    @GetMapping("/books/v1/volumes")
    Results findBookByQuery(@RequestParam(value = "q") String q);

}