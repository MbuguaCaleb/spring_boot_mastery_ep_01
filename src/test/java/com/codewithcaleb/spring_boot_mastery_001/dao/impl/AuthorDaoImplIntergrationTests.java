package com.codewithcaleb.spring_boot_mastery_001.dao.impl;


import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImplIntergrationTests {

    private final AuthorDaoImpl underTest;


    //autowired is used in tests for dependency injection
    @Autowired
    public AuthorDaoImplIntergrationTests(AuthorDaoImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }
}
