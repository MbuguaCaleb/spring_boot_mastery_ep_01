package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import com.codewithcaleb.spring_boot_mastery_001.dao.BookDao;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import com.codewithcaleb.spring_boot_mastery_001.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> find(String isbn) {
        //When using JDBC remeber that you must have custom  mappings to and fro Java Objects
        List<Book> results = jdbcTemplate.query("SELECT id,name,age FROM authors WHERE id = ? LIMIT 1",
                new BookDaoImpl.BookRowMapper(), isbn);
        return results.stream().findFirst();
    }

    public static  class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .build();
        }
    }
}
