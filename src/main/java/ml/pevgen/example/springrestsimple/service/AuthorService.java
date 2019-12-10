package ml.pevgen.example.springrestsimple.service;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.example.springrestsimple.dto.AuthorDto;
import ml.pevgen.example.springrestsimple.mapper.AuthorMapper;
import ml.pevgen.example.springrestsimple.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Page<AuthorDto> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable).map(authorMapper::toDto);
    }

    public AuthorDto findById(Long id) {
        return authorMapper.toDto(authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found")));
    }

}
