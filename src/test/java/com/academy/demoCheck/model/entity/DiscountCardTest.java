package com.academy.demoCheck.model.entity;

import com.academy.demoCheck.mapper.DiscountCardMapper;
import com.academy.demoCheck.model.dto.DiscountCardDto;
import com.academy.demoCheck.repository.DiscountCardRepository;
import com.academy.demoCheck.service.impl.ReceiptServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author : Volha Salash
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public
class DiscountCardTest {
    private static final Long TEST_ID = 12L;
    private static final BigDecimal TEST_DISCOUNT = BigDecimal.valueOf(0.5);
    private static final Integer TEST_NUMBER = 5214;
    private static final DiscountCard TEST_CARD;
    private static final DiscountCardDto TEST_CARD_DTO;
    private static final List<DiscountCard> TEST_CARD_LIST = new ArrayList<>();
    private static final List<DiscountCardDto> TEST_CARD_DTO_LIST = new ArrayList<>();

    static {
        TEST_CARD = new DiscountCard();
        TEST_CARD.setId(Math.toIntExact(TEST_ID));
        TEST_CARD.setDiscount(TEST_DISCOUNT);
        TEST_CARD_LIST.add(TEST_CARD);

        TEST_CARD_DTO = new DiscountCardDto(TEST_ID, TEST_NUMBER, TEST_DISCOUNT);
        TEST_CARD_DTO_LIST.add(TEST_CARD_DTO);
    }

    @MockBean
    DiscountCardMapper discountCardMapper;
    @MockBean
    DiscountCardRepository discountCardRepository;

    @Test
    void testGetAll() {
        when(discountCardRepository.findAll()).thenReturn(TEST_CARD_LIST);
        when(discountCardMapper.toDTOList(any())).thenReturn(TEST_CARD_DTO_LIST);
        var actualAll = discountCardRepository.findAll();
        assertSame(TEST_CARD_DTO_LIST, actualAll);
        assertFalse(actualAll.isEmpty());
        verify(discountCardRepository).findAll();
        verify(discountCardMapper).toDTOList(any());
    }

    @Test
    void testGetByNumber() {
        var ofResult = Optional.of(TEST_CARD);
        when(discountCardRepository.findByNumber(any())).thenReturn(ofResult);
        when(discountCardMapper.toDTO(any())).thenReturn(TEST_CARD_DTO);
        var actualByNumber = discountCardRepository.findByNumber(Math.toIntExact(TEST_ID));
        assertSame(TEST_CARD_DTO, actualByNumber);
        assertEquals(TEST_DISCOUNT, actualByNumber);
        verify(discountCardRepository).findById(any());
        verify(discountCardMapper).toDTO(any());
    }
}