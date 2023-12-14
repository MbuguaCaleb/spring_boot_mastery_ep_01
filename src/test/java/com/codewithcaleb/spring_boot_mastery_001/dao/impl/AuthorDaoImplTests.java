package com.codewithcaleb.spring_boot_mastery_001.dao.impl;


import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


//UnitTest-->Best done via Mockito
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    // -->before each test is run a new instance of AutoDaoImpl is creeated for us injected
    //remeber you may have more than one test case in the class
    @InjectMocks
    private AuthorDaoImpl authorDaoTest;


    @Test
    public void testThatCreateAuthorGeneratesCorrectSQL() {
        //Object that i want to put inside my DB
        Author author = TestDataUtil.createTestAuthor();

        //method i am testing where a JDBC create SQL will be executed
        authorDaoTest.create(author);

        //When i do a create,there is an SQL that is expected
        //since its jdbc being used, we can use mockito verify method
        //to assert that result of SQL from the create method

        //i am testing whether this is the SQL that was generated when i called create method

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),
                eq(1L),eq("Caleb Mbugua"),eq(28)
        );

    }



    //wHEN Using JDBC remember we have to handle type conversions all by ourselves
    //we are passing our custom created AuthorRowMapper,inside argument ArgumentMatchers
    @Test
    public void testThatFindOneGeneratesTheCorrectSQL(){
        authorDaoTest.findOne(1L);
        verify(jdbcTemplate).
                query(eq("SELECT id,name,age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L));
    }
}
