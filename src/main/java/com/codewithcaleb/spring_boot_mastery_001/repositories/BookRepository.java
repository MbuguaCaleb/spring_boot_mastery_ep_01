package com.codewithcaleb.spring_boot_mastery_001.repositories;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity,String> {
}
