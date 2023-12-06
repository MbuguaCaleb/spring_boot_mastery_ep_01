package com.codewithcaleb.spring_boot_mastery_001.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

//responsible for interacting with the database as well as Java Object to SQL mapping
public class BookDaoImpl {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
