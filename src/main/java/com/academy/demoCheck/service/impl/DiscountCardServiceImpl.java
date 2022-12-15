package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.repository.impl.DiscountCardRepositoryImpl;
import com.academy.demoCheck.service.interfaces.DiscountCardReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : Volha Salash
 */
@Service
@AllArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardReaderService {

    @Override
    public void read(DiscountCardRepositoryImpl discountCardRepository) {
        File cards = new File("src/main/resources/discountCards");
        try (Scanner scanner = new Scanner(cards)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                Integer id = 1;
                Integer number = Integer.parseInt(data[0]);
                Integer discount = Integer.parseInt(data[1]);
                discountCardRepository.addDiscountCard(id, number, discount);
            }
        } catch (FileNotFoundException e) {
            System.out.println("DISCOUNT CARD FILE - NOT FOUND");
        }
    }
}
