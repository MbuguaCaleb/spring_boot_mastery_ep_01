package com.codewithcaleb.spring_boot_mastery_001.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    //Woow// JDBC Tempalate takes in a datasource as an arugument
    //This is where we pass the DB Connection details
    @Bean
    public  JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
