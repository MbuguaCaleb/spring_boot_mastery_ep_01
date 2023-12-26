package com.codewithcaleb.spring_boot_mastery_001.controllers;

import com.codewithcaleb.spring_boot_mastery_001.domain.dto.BookDto;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;
import com.codewithcaleb.spring_boot_mastery_001.mappers.Mapper;
import com.codewithcaleb.spring_boot_mastery_001.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    //adding the book service
    private BookService bookService;

    //adding the mapper interface
    private Mapper<BookEntity,BookDto> bookMapper;


    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn,
                                              @RequestBody BookDto bookDto){

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        bookService.createBook(isbn,bookEntity);

    }
}
