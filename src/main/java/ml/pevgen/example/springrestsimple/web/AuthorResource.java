package ml.pevgen.example.springrestsimple.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.AuthorDto;
import ml.pevgen.example.springrestsimple.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "authors")
@RequestMapping(AuthorResource.RESOURCE_URI_AUTHORS)
public class AuthorResource {

    static final String RESOURCE_URI_AUTHORS = "/authors";

    private AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation(value = "Finds all Authors in the library", notes = "Notes for the operation")
    public Page<AuthorDto> findAll(Pageable pageable) {
        return this.authorService.findAll(pageable);
    }

}
