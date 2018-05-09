package com.github.sttraeger.sqsdemoserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Server implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Creating table");

        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS cars(" +
                "vin varchar(10) NOT NULL PRIMARY KEY, " +
                "manufacturer varchar(100) NOT NULL, " +
                "model varchar(20) NOT NULL, " +
                "hp integer NOT NULL, " +
                "registrationDate date NOT NULL, " +
                "mileage float NOT NULL)");

    }
}
