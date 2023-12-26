package com.codewithcaleb.spring_boot_mastery_001.services.impl;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;
import com.codewithcaleb.spring_boot_mastery_001.repositories.BookRepository;
import com.codewithcaleb.spring_boot_mastery_001.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);
        return bookRepository.save(bookEntity);
    }
}
