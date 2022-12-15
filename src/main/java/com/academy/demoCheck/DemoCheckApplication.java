package com.academy.demoCheck;

import com.academy.demoCheck.model.repository.impl.CheckRepositoryImpl;
import com.academy.demoCheck.model.repository.impl.DiscountCardRepositoryImpl;
import com.academy.demoCheck.model.repository.impl.ProductRepositoryImpl;
import com.academy.demoCheck.service.impl.CheckServiceImpl;
import com.academy.demoCheck.service.impl.DiscountCardServiceImpl;
import com.academy.demoCheck.service.impl.PrintCheckServiceImpl;
import com.academy.demoCheck.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCheckApplication implements CommandLineRunner {

    private static final ProductRepositoryImpl productDao = new ProductRepositoryImpl();
    private static final DiscountCardRepositoryImpl cardDao = new DiscountCardRepositoryImpl();
    private static final CheckRepositoryImpl checkDao = new CheckRepositoryImpl();
    private static final PrintCheckServiceImpl outputCheck = new PrintCheckServiceImpl (productDao, cardDao, checkDao);

    private static final Logger LOG = LoggerFactory
            .getLogger(DemoCheckApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(DemoCheckApplication.class, args);

        ProductServiceImpl productReader = new ProductServiceImpl();
        productReader.read(productDao);
        //создали и сохранили 20 продуктов из файла products; sale: 1 - товар на акции, 0 - не на акции

        DiscountCardServiceImpl cardReader = new DiscountCardServiceImpl();
        cardReader.read(cardDao);
        // создали и сохранили 5 скидочных карт из файла cards
        CheckServiceImpl checkReader = new CheckServiceImpl();
        checkReader.read(checkDao);
        //создали и сохранили содержимое чека (для примера) из файла checkRunner

        outputCheck.printCheck(4444);
        //печать чека в файл check, с учетом скидки по предьявленной карте

        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
    }
}