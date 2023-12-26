package com.codewithcaleb.spring_boot_mastery_001.services;

import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;

//Interfaces just define the behaviour of our classes

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

}
