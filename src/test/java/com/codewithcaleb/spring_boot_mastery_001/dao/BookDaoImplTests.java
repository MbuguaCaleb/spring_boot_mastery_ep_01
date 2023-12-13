package com.codewithcaleb.spring_boot_mastery_001.dao;


import com.codewithcaleb.spring_boot_mastery_001.dao.impl.BookDaoImpl;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSQL() {

        Book book = Book.builder()
                .isbn("8486-76-897897-3")
                .title("Caleb Masters Spring")
                .authorId(1L)
                .build();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)"),
                eq("8486-76-897897-3"),
                eq("Caleb Masters Spring"),
                eq(1L)
        );
    }
}
