package com.codewithcaleb.spring_boot_mastery_001.repositories;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

    private final AuthorRepository underTest;


    //autowired is used in tests for dependency injection
    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        Author testAuthorA = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorA);
        Author testAuthorB = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorB);
        Author testAuthorC = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorC);

        Iterable<Author> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .contains(testAuthorA,testAuthorB,testAuthorC);
    }


    @Test
    public void testThatAuthorCanBeUpdated(){
        //i need to create then update
        Author testAuthorA = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorA);

        //save is used for creating and updating in Spring Data JPA
        testAuthorA.setName("UPDATED");
        underTest.save(testAuthorA);

        //finding the updated author to assert the results
        Optional<Author> result = underTest.findById(testAuthorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testAuthorA);
    }

    @Test
    public void testAuthorCanBeDeleted(){

        //creating an author
        Author testAuthorA = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorA);

        Long authorId = testAuthorA.getId();

        underTest.deleteById(authorId);

        //Get the optional
        Optional<Author> result = underTest.findById(authorId);

        //assert
        assertThat(result).isEmpty();

    }

}
