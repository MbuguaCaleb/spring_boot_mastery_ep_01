package com.codewithcaleb.spring_boot_mastery_001.services.impl;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import com.codewithcaleb.spring_boot_mastery_001.repositories.AuthorRepository;
import com.codewithcaleb.spring_boot_mastery_001.services.AuthorService;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {


    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
