package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.dao.AuthorDao;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
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
public class BookDaoImplIntegerationTests {

    //I want to test whether a book was created
    //Whether i can fetch the crated book
    private BookDaoImpl underTest;
    private AuthorDao authorDao;

    @Autowired //I Am slight outside the spring context not like other spring test applications
    private BookDaoImplIntegerationTests(BookDaoImpl underTest,AuthorDao authorDao){
        this.underTest = underTest;
        this.authorDao = authorDao;
    }


    //Means that if this particular test runs i do not need to go to postman at all
    //Imagine a very large application and you have made a change
    //Production code should be perfect
    @Test
    public void testThatABookCanBeCreatedAndRecalled(){
        //Remember there is a foreign key relationship, between the author and the Book
        //Creating the Author First
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){

        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book testBookA = TestDataUtil.createTestBookA();
        testBookA.setAuthorId(author.getId());
        underTest.create(testBookA);
        Book testBookB = TestDataUtil.createTestBookB();
        testBookB.setAuthorId(author.getId());
        underTest.create(testBookB);
        Book testBookC = TestDataUtil.createTestBookC();
        testBookC.setAuthorId(author.getId());
        underTest.create(testBookC);

        List<Book> results = underTest.find();
        assertThat(results)
                .hasSize(3)
                .containsExactly(testBookA,testBookB,testBookC);

    }
}
