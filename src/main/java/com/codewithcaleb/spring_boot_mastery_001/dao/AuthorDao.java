package com.codewithcaleb.spring_boot_mastery_001.dao;

import com.codewithcaleb.spring_boot_mastery_001.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);

}
