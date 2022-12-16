package com.academy.demoCheck;

import com.academy.demoCheck.model.entity.Check;
import com.academy.demoCheck.repository.CheckRepository;
import com.academy.demoCheck.repository.DiscountCardRepository;
import com.academy.demoCheck.repository.ProductRepository;
import com.academy.demoCheck.service.impl.CheckCreatorImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DemoCheckApplication {

    CheckRepository checkRepository;

    DiscountCardRepository cardRepository;

    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoCheckApplication.class, args);
        log.info("APPLICATION FINISHED");
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    {
        CheckCreatorImpl checkCreator = new CheckCreatorImpl(checkRepository, cardRepository, productRepository);
        return args -> checkCreator.print(2234);
    }
}
