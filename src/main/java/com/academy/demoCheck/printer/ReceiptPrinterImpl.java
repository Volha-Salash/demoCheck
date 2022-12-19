package com.academy.demoCheck.printer;

import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.entity.Receipt;
import com.academy.demoCheck.service.interfaces.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

/**
 * @author : Volha Salash
 */
@Component
@RequiredArgsConstructor
public class ReceiptPrinterImpl implements ReceiptPrinter {

    private final ReceiptService receiptService;

    @SneakyThrows
    public void print(CheckConsoleDto checkDto) {
        // генерация данных по чеку из дто (метод сервиса)
        //заполнить шаблон чека из этих данных
        //вывести в консоль получ.результат


        Receipt receipt = receiptService.createReceipt(checkDto);

        int length = 60;
        String delimiter = "-".repeat(length);
        System.out.println(delimiter);
        String receiptString = "RECEIPT";
        System.out.println(center(length, receiptString));
        String market = "MARKET NAME";
        System.out.println(center(length, market));
        String date = "DATE: %s";
        System.out.println(String.format(date, receipt.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        String time = "TIME: %s";
        System.out.println(String.format(time, receipt.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        System.out.println(delimiter);
        String productLine = "%-3s%-27s%10s%10s%10s";
        System.out.println(String.format(productLine, "QTY", "NAME", "PRICE", "DISC", "TOTAL"));
        receipt.getProducts().forEach(receiptProduct ->
                System.out.println(String.format(productLine, receiptProduct.getAmount(),
                        receiptProduct.getProduct().getName(), receiptProduct.getTotalSum(),
                        receiptProduct.getDiscountSum(), receiptProduct.getTotalSumWithDiscount())));
        System.out.println(delimiter);
        String totalLine = "%-50s%10s";
        if (receipt.getDiscountCard() != null) {
            System.out.println(String.format(totalLine, "Discount card", receipt.getDiscountCard().getNumber()));
        }
        System.out.println(delimiter);
        System.out.println(String.format(totalLine, "Price without discount", receipt.getTotalSum()));
        System.out.println(String.format(totalLine, "Discount", receipt.getDiscountSum()));
        System.out.println(String.format(totalLine, "TOTAL", receipt.getTotalSumWithDiscount()));
        System.out.println(delimiter);

    }

    private String center(int length, String str) {
        return " ".repeat((length - str.length()) / 2) + str;
    }
}
