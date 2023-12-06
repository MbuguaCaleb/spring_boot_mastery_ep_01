package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import com.codewithcaleb.spring_boot_mastery_001.dao.AuthorDao;
import com.codewithcaleb.spring_boot_mastery_001.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;


//responsible for interacting with the database as well as Java Object to SQL mapping
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;


    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Author author) {

        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?,?,?)",
                author.getId(), author.getName(), author.getAge());
    }
}
