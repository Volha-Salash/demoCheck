package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.entity.Check;
import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.entity.Product;
import com.academy.demoCheck.repository.CheckRepository;
import com.academy.demoCheck.repository.DiscountCardRepository;
import com.academy.demoCheck.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * @author : Volha Salash
 */
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CheckCreatorImpl {

    CheckRepository checkRepository;
    DiscountCardRepository discountCardRepository;
    ProductRepository productRepository;

    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();


    public int sale() {
        int count = 0;
        for (Check products : checkRepository.findAll()) {
            Optional<Product> sale = productRepository.findById(products.getId());
            if (sale.get().getSale() == 1) {
                count++;
            }
        }
        return count;
    }


    public void discount(Integer discount, Double totalSum, PrintWriter pw) {
        if (discount != 0) {
            pw.println("Discount on presented card\t\t" + discount + "%");
            pw.println("Amount including discount\t\t" + BigDecimal.valueOf(totalSum
                    * ((100 - discount)) / 100).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }
    }


    public void print(Integer numberCard) {
        File output = new File("output");
        try (PrintWriter pw = new PrintWriter(output)) {
            DiscountCard card = discountCardRepository.findByNumber(numberCard);
            pw.println("\t\t  $Test shop$");
            pw.println("\t\t MINSK, NIAMIGA");
            pw.println("\t\t   p.3753787400 \n");
            pw.println("\t cashier: №1\t date: " + date);
            pw.println("\t\t\t\t\t time: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
            pw.println("-----------------------------------------");
            pw.println("Col.\t" + "Name\t\t" + "Price\t" + "Sum");
            Double totalSum = BigDecimal.valueOf(find(pw)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            pw.println("=========================================");
            pw.println("Sum\t\t\t\t\t\t\t\t" + totalSum);
            discount(card.getDiscount(), totalSum, pw);
            pw.println("*****************************************");
            pw.println("\t\t\tThanks for a purchase!");
            pw.flush();
        } catch (NullPointerException e) {
            System.out.println("Failed to determine the presented discount card");
        } catch (FileNotFoundException e) {
            System.out.println("\n" + "Check file not found");
        }
    }


    public Double find(PrintWriter pw) {
        try {
            double totalSum = 0;
            for (Check checkList : checkRepository.findAll()) {
                Optional<Product> productInShop = productRepository.findById(checkList.getId());
                double sum = productInShop.get().getPrice() * checkList.getAmount();
                String field = checkList.getAmount() + "\t\t" + productInShop.get().getName() + "\t\t\t\t" +
                        productInShop.get().getPrice() + "\t" + sum;
                if (sale() > 4 && productInShop.get().getSale() == 1) {
                    pw.println(field);
                    sum = productInShop.get().getPrice() * checkList.getAmount() * 0.9;
                    pw.println("\t( \"" + productInShop.get().getName() + "\" promotion -10%)\t"
                            + BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue());
                } else {
                    pw.println(field);
                }
                totalSum = totalSum + sum;
            }
            return totalSum;
        } catch (NullPointerException e) {
            throw new NullPointerException("\n" + "There is no product with the selected id");
        }
    }

}
