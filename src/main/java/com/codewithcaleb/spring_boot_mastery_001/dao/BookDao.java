package com.codewithcaleb.spring_boot_mastery_001.dao;

import com.codewithcaleb.spring_boot_mastery_001.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();
}
