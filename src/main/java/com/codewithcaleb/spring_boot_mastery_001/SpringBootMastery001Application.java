package com.codewithcaleb.spring_boot_mastery_001;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class SpringBootMastery001Application implements CommandLineRunner {

    private final DataSource dataSource;

    public SpringBootMastery001Application(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMastery001Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("datasource" + dataSource.toString());
       final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
       restTemplate.execute("select 1");

    }
}
