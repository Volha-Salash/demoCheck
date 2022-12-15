package com.academy.demoCheck;

import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoCheckApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(DemoCheckApplication.class);

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(DemoCheckApplication.class, args);


        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            // save a few products
            repository.save(new Product(1, "Cream", 1.5, 2));
            repository.save(new Product(2, "Wafer", 1.0, 5));

            // fetch all products
            log.info("Products found with findAll():");
            log.info("-------------------------------");
            for (Product product : repository.findAll()) {
                log.info(product.toString());
            }
            log.info("");

            // fetch an individual Product by ID
            Optional<Product> product = repository.findById(1);
            log.info("Product found with findById(1):");
            log.info("--------------------------------");
            log.info(product.toString());
            log.info("");


            // fetch card by number
            /*
            log.info("Card found with findByNumber('4444'):");
            log.info("--------------------------------------------");
            repository.findById(4)

             */
        };
    }

}