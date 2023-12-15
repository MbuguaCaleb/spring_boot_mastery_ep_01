package com.codewithcaleb.spring_boot_mastery_001.repositories;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
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
        Author author = TestDataUtil.createTestAuthorA();

        //As i create the book because i have the cascade i will also create the author
        Book book = TestDataUtil.createTestBookA(author);
        this.underTest.save(book);
        Optional<Book> result = this.underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }


    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){

        Author author = TestDataUtil.createTestAuthorA();
        Book testBookA = TestDataUtil.createTestBookA(author);
        underTest.save(testBookA);

        Book testBookB = TestDataUtil.createTestBookB(author);
        underTest.save(testBookB);

        Book testBookC = TestDataUtil.createTestBookC(author);
        underTest.save(testBookC);

        Iterable<Book> results = underTest.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(testBookA,testBookB,testBookC);

    }



    @Test
    public void testThatBookCanBeUpdated(){

        Author author = TestDataUtil.createTestAuthorA();
        Book testBookA = TestDataUtil.createTestBookA(author);
        underTest.save(testBookA);

        testBookA.setTitle("Updated");
        underTest.save(testBookA);

        //get single book
        Optional<Book> result = underTest.findById(testBookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testBookA);

    }


    @Test
    public void testThatBookCanBeDeleted(){
        Author author = TestDataUtil.createTestAuthorA();
        //create a book (Cascade will create author associated with the book)
        Book testBookA = TestDataUtil.createTestBookA(author);

        underTest.save(testBookA);

        String isbn = testBookA.getIsbn();
        underTest.deleteById(isbn);

        //find deleted Optional
        Optional<Book> result = underTest.findById(isbn);
        assertThat(result).isEmpty();

    }
}
