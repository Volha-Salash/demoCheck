package com.academy.demoCheck;

import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.dto.console.ProductConsoleDto;
import com.academy.demoCheck.printer.ReceiptPrinter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class DemoCheckApplication implements CommandLineRunner {

    private final ReceiptPrinter receiptPrinter;

    public static void main(String[] args) {
        SpringApplication.run(DemoCheckApplication.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        args = new String[] {"2-1", "4-5", "1-1", "card-1234"};
        CheckConsoleDto checkDto = new CheckConsoleDto();
        checkDto.setDiscountCardNumber(parseCard(args));
        checkDto.setProducts(parseProductList(args));

        receiptPrinter.print(checkDto);
    }

    private Integer parseCard(String... args) {
        return Stream.of(args).filter(s -> s.startsWith("card"))
                .findFirst()
                .map(s -> Integer.parseInt(s.split("-")[1]))
                .orElse(null);
    }

    private ProductConsoleDto parseProduct(String product) {
        String[] split = product.split("-");
        ProductConsoleDto productDto = new ProductConsoleDto();
        productDto.setId(Long.parseLong(split[0]));
        productDto.setAmount(Integer.parseInt(split[1]));
        return productDto;
    }

    private List<ProductConsoleDto> parseProductList(String... args) {
        return Stream.of(args)
                .filter(s -> s.matches("\\d+-\\d+"))
                .map(this::parseProduct)
                .collect(Collectors.toList());
    }
}
