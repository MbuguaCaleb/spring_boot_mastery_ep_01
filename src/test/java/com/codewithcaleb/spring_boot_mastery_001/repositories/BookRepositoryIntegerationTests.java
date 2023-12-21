package com.codewithcaleb.spring_boot_mastery_001.repositories;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.AuthorEntity;
import com.codewithcaleb.spring_boot_mastery_001.domain.entities.BookEntity;
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
public class BookRepositoryIntegerationTests {

    //I want to test whether a book was created
    //Whether i can fetch the crated book
    private BookRepository underTest;

    @Autowired //I Am slight outside the spring context not like other spring test applications
    private BookRepositoryIntegerationTests(BookRepository underTest){
        this.underTest = underTest;
    }


    //Means that if this particular test runs i do not need to go to postman at all
    //Imagine a very large application and you have made a change
    //Production code should be perfect
    @Test
    public void testThatABookCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();

        //As i create the book because i have the cascade i will also create the author
        BookEntity bookEntity = TestDataUtil.createTestBookA(authorEntity);
        this.underTest.save(bookEntity);
        Optional<BookEntity> result = this.underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }


    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){

        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity testBookAEntity = TestDataUtil.createTestBookA(authorEntity);
        underTest.save(testBookAEntity);

        BookEntity testBookBEntity = TestDataUtil.createTestBookB(authorEntity);
        underTest.save(testBookBEntity);

        BookEntity testBookCEntity = TestDataUtil.createTestBookC(authorEntity);
        underTest.save(testBookCEntity);

        Iterable<BookEntity> results = underTest.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(testBookAEntity, testBookBEntity, testBookCEntity);

    }



    @Test
    public void testThatBookCanBeUpdated(){

        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        BookEntity testBookAEntity = TestDataUtil.createTestBookA(authorEntity);
        underTest.save(testBookAEntity);

        testBookAEntity.setTitle("Updated");
        underTest.save(testBookAEntity);

        //get single book
        Optional<BookEntity> result = underTest.findById(testBookAEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testBookAEntity);

    }


    @Test
    public void testThatBookCanBeDeleted(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        //create a book (Cascade will create author associated with the book)
        BookEntity testBookAEntity = TestDataUtil.createTestBookA(authorEntity);

        underTest.save(testBookAEntity);

        String isbn = testBookAEntity.getIsbn();
        underTest.deleteById(isbn);

        //find deleted Optional
        Optional<BookEntity> result = underTest.findById(isbn);
        assertThat(result).isEmpty();

    }
}
