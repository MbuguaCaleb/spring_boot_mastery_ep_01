package com.codewithcaleb.spring_boot_mastery_001.repositories;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled(){
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);
        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);
        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .contains(testAuthorAEntity, testAuthorBEntity, testAuthorCEntity);
    }


    @Test
    public void testThatAuthorCanBeUpdated(){
        //i need to create then update
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);

        //save is used for creating and updating in Spring Data JPA
        testAuthorAEntity.setName("UPDATED");
        underTest.save(testAuthorAEntity);

        //finding the updated author to assert the results
        Optional<AuthorEntity> result = underTest.findById(testAuthorAEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testAuthorAEntity);
    }

    @Test
    public void testAuthorCanBeDeleted(){

        //creating an author
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);

        Long authorId = testAuthorAEntity.getId();

        underTest.deleteById(authorId);

        //Get the optional
        Optional<AuthorEntity> result = underTest.findById(authorId);

        //assert
        assertThat(result).isEmpty();

    }


    //Remember you must populate data for your tests each time
    //You are not using a Production Database
    @Test
    public void testThatGetAuthorsWithAgeLessThan(){
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);

        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);

        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity> results = underTest.ageLessThan(50);

        assertThat(results).containsExactly(testAuthorBEntity, testAuthorCEntity);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan(){
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);

        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);

        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity> results = underTest.findAuthorsWithAgeGreaterThan(50);
        assertThat(results).containsExactly(testAuthorAEntity);
    }

}
