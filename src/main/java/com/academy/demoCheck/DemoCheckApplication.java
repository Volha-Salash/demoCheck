package com.academy.demoCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCheckApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
            .getLogger(DemoCheckApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(DemoCheckApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
    }
}