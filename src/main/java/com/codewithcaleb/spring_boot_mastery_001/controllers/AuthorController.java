package com.codewithcaleb.spring_boot_mastery_001.controllers;

//Controllers are the presentation Layer


import com.codewithcaleb.spring_boot_mastery_001.domain.dto.AuthorDto;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import com.codewithcaleb.spring_boot_mastery_001.mappers.Mapper;
import com.codewithcaleb.spring_boot_mastery_001.mappers.impl.AuthorMapperImpl;
import com.codewithcaleb.spring_boot_mastery_001.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {


    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto author) {

        //we will map the dto into the entity that is being taken
        //as a parameter in the service
        //Model mapper is a liblary that maps from one class to the other

        AuthorEntity authorEntity = authorMapper.mapFrom(author);

        AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

}
