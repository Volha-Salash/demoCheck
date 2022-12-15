package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.entity.Check;
import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.model.repository.impl.CheckRepositoryImpl;
import com.academy.demoCheck.model.repository.impl.DiscountCardRepositoryImpl;
import com.academy.demoCheck.model.repository.impl.ProductRepositoryImpl;
import com.academy.demoCheck.service.interfaces.PrinterService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author : Volha Salash
 */
@Service
public class PrintCheckServiceImpl implements PrinterService {

    private final ProductRepositoryImpl productRepository;
    private final DiscountCardRepositoryImpl discountCardRepository;
    private final CheckRepositoryImpl checkRepository;
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now();

    public PrintCheckServiceImpl(ProductRepositoryImpl productRepository, DiscountCardRepositoryImpl discountCardRepository, CheckRepositoryImpl checkRepository) {
        this.productRepository = productRepository;
        this.discountCardRepository = discountCardRepository;
        this.checkRepository = checkRepository;
    }

    @Override
    public void printCheck(Integer number) {
        File file = new File("src/main/resources/printCheck");
        try (PrintWriter pw = new PrintWriter(file)) {
            DiscountCard card = discountCardRepository.getDiscountCardsByNumber(number);
            pw.println("\t\t\t  -=SHOP SUN=-");
            pw.println("\t\t MINSK, NYAMIGA 3");
            pw.println("\t\t   тел. 80445975900 \n");
            pw.println("\t EMPLOYEE: №1234 \t DATE: " + date);
            pw.println("\t\t\t\t\t TIME: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
            pw.println("-----------------------------------------");
            pw.println("V.\t" + "NAME\t\t" + "PRICE\t" + "TOTAL COST");
            Double totalSum = BigDecimal.valueOf(findProduct(pw))
                    .setScale(2, RoundingMode.HALF_UP).doubleValue();
            pw.println("=========================================");
            pw.println("TOTAL SUM\t\t\t\t\t\t\t\t" + totalSum);
            discount(card.getDiscount(), totalSum, pw);
            pw.println("*****************************************");
            pw.println("\t\t\tTHANKS!");
        } catch (NullPointerException e) {
            System.out.println("DISCOUNT CARD IS NOT FOUND");
        } catch (FileNotFoundException e) {
            System.out.println("PRINTER-FILE IS NOT FOUND");
        }
    }

    @Override
    public Double findProduct(PrintWriter pw) {
        try {
            double totalSum = 0;
            for (Check productInCheck : checkRepository.getChecks()) {
                Product productInShop = productRepository.getProductById(productInCheck.getId());
                double sum = productInShop.getPrice() * productInCheck.getAmount();
                String field = productInCheck.getAmount() + "\t\t" + productInShop.getName() + "\t\t\t\t" +
                        productInShop.getPrice() + "\t" + sum;
                if (saleProduct() > 4 && productInShop.getSale() == 1) {
                    pw.println(field);
                    sum = productInShop.getPrice() * productInCheck.getAmount() * 0.9;
                    pw.println("\t(PRODUCT \"" + productInShop.getName() + "\"WITH SALE -10%)\t"
                            + BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue());
                } else {
                    pw.println(field);
                }
                totalSum = totalSum + sum;
            }
            return totalSum;
        } catch (NullPointerException e) {
            throw new NullPointerException("PRODUCT WITH THESE ID IS NOT FOUND");
        }
    }

    @Override
    public void discount(Integer discount, Double totalSum, PrintWriter pw) {
        if (discount != 0) {
            pw.println("DISCOUNT WITH CARD\t\t" + discount + "%");
            pw.println("SUM WITH ALL DISCOUNTS\t\t\t\t" + BigDecimal.valueOf(totalSum
                    * ((100 - discount)) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }
    }

        @Override
        public int saleProduct () {
            int count = 0;
            for (Check productInCheck : checkRepository.getChecks()) {
                Product saleProduct = productRepository.getProductById(productInCheck.getId());
                if (saleProduct.getSale() == 1) {
                    count++;
                }
            }
            return count;
        }
}
