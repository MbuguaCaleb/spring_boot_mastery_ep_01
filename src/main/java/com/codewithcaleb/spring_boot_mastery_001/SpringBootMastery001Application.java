package com.codewithcaleb.spring_boot_mastery_001;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class SpringBootMastery001Application{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMastery001Application.class, args);
    }

}
