package com.github.sttraeger.sqsdemoserver;

import com.github.sttraeger.sqsdemoserver.database.QueryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author sttrae
 * The main class for the WebService.
 */
@SpringBootApplication
public class Server implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        logger.info("Starting Car Webservice...");
        SpringApplication.run(Server.class, args);
    }

    /**
     * Creates the 'cars' table in PostgreSQL if not exists.
     *
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        logger.info("Creating table 'cars' (if not existing).");
        this.jdbcTemplate.execute(QueryHelper.CREATE_TABLE_CARS);
        // Trucnate table to prevent duplicate primary key exception
        this.jdbcTemplate.execute(QueryHelper.TRUNCATE_CARS);
        logger.info("Insert sample cars...");
        this.jdbcTemplate.execute(QueryHelper.CREATE_TEST_CARS);

    }
}
