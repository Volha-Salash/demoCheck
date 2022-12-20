package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.model.dto.DiscountCardDto;
import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.entity.Receipt;
import com.academy.demoCheck.model.entity.ReceiptProduct;
import com.academy.demoCheck.repository.DiscountCardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * @author : Volha Salash
 */
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class ReceiptServiceImplTest {

    private static final BigDecimal TEST_totalSum = BigDecimal.valueOf(10);
    private static final BigDecimal TEST_discountSum = BigDecimal.valueOf(1);
    private static final BigDecimal TEST_totalSumWithDiscount = BigDecimal.valueOf(9.5);
    private static final DiscountCard TEST_CARD = new DiscountCard();
    private static final DiscountCardDto TEST_CARD_DTO = new DiscountCardDto();
    private static final List<ReceiptProduct> TEST_PRODUCTS = new ArrayList<>();
    private static final Integer TEST_NUMBER = 1234;
    private static final Long TEST_ID = 12L;
    private static final BigDecimal TEST_DISCOUNT = BigDecimal.valueOf(5);
    private static final List<DiscountCardDto> TEST_CARD_DTO_LIST = new ArrayList<>();
    private static final Receipt TEST_RECEIPT = new Receipt();
    private static final CheckConsoleDto CHECK_CONSOLE_DTO = new CheckConsoleDto();

    static {
        TEST_RECEIPT.setDiscountCard(TEST_CARD);
        TEST_RECEIPT.setProducts(TEST_PRODUCTS);
        TEST_RECEIPT.setTotalSumWithDiscount(TEST_totalSumWithDiscount);
        TEST_RECEIPT.setDiscountSum(TEST_discountSum);
        TEST_RECEIPT.setTotalSum(TEST_totalSum);
    }


    public ReceiptServiceImplTest(DiscountCardRepository discountCardRepository, ReceiptServiceImpl receiptService) {
        this.discountCardRepository = discountCardRepository;
        this.receiptService = receiptService;
    }

    @Mock
    private final DiscountCardRepository discountCardRepository;

    @Mock
    private final ReceiptServiceImpl receiptService;

    @Test
    @Disabled
    void createReceipt() {
        var ofResult = Optional.of(TEST_CARD);
        when(discountCardRepository.findByNumber(any())).thenReturn(ofResult);
        when(receiptService.createReceipt(CHECK_CONSOLE_DTO).getDiscountCard().getNumber());
        when(receiptService.createReceipt(CHECK_CONSOLE_DTO).getProducts().get(1).getProduct());
        when(receiptService.createReceipt(CHECK_CONSOLE_DTO).getDiscountSum());
        when(receiptService.createReceipt(CHECK_CONSOLE_DTO).getTotalSumWithDiscount());
        when(receiptService.createReceipt(CHECK_CONSOLE_DTO).getTotalSum());
        var actualCheck = discountCardRepository.findByNumber(Math.toIntExact(TEST_ID));
        assertSame(TEST_RECEIPT, actualCheck);
        assertEquals(TEST_RECEIPT, actualCheck);

    }
}
