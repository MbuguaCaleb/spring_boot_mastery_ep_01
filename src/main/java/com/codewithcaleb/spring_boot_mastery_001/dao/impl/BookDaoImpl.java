package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import com.codewithcaleb.spring_boot_mastery_001.dao.BookDao;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

//responsible for interacting with the database as well as Java Object to SQL mapping
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (isbn,title,author_id) VALUES (?,?,?)",
               book.getIsbn(),
                book.getTitle(),
                book.getAuthorId());

    }
}
