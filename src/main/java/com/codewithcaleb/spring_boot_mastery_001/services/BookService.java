package com.codewithcaleb.spring_boot_mastery_001.services;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity bookEntity);
}
