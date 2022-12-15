package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.repository.impl.CheckRepositoryImpl;
import com.academy.demoCheck.service.interfaces.CheckReaderService;
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
public class CheckServiceImpl implements CheckReaderService {

    @Override
    public void read(CheckRepositoryImpl checkRepository) {
        File checkRunner = new File("src/main/resources/checks");
        try (Scanner scanner = new Scanner(checkRunner)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                Integer id = Integer.parseInt(data[0]);
                Integer amount = Integer.parseInt(data[1]);
                checkRepository.createCheck(id, amount);
            }
        } catch (FileNotFoundException e) {
            System.out.println("CHECK FILE WITH PRODUCTS NOT FOUND");
        }
    }
}
