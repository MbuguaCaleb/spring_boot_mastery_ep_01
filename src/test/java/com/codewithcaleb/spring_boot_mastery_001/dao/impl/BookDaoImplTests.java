package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import com.codewithcaleb.spring_boot_mastery_001.TestDataUtil;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl bookImplTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSQL() {
        Book book = TestDataUtil.createTestBookA();
        bookImplTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)"),
                eq("8486-76-897897-3"),
                eq("Caleb Masters Spring"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindBookGeneratesCorrectSQL(){
        bookImplTest.findOne("8486-76-897897-3");

        verify(jdbcTemplate).
                query(eq("SELECT isbn,title,author_id FROM books WHERE isbn = ? LIMIT 1"),
                        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                        eq("8486-76-897897-3"));

    }

    @Test
    public void testThatFindManyGeneratesCorrectSQL(){
        bookImplTest.find();
        verify(jdbcTemplate).query(eq("SELECT isbn,title,author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());

    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Book testBookA = TestDataUtil.createTestBookA();
        bookImplTest.update("8486-76-897897-3",testBookA);

        verify(jdbcTemplate)
                .update("UPDATE books SET isbn = ? ,title= ?,author_id= ? WHERE isbn= ?",
                "8486-76-897897-3","Caleb Masters Spring",1L,"8486-76-897897-3");

    }


}
