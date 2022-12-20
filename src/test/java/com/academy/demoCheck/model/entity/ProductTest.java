package com.academy.demoCheck.model.entity;

import com.academy.demoCheck.mapper.ProductMapper;
import com.academy.demoCheck.model.dto.ProductDto;
import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.dto.console.DiscountCardConsoleDto;
import com.academy.demoCheck.repository.ProductRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author : Volha Salash
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductTest {
    private static final Long TEST_ID = 1L;
    private static final String TEST_NAME = "Name";
    private static final BigDecimal TEST_PRICE = BigDecimal.valueOf(10.0);
    private static final boolean TEST_ISsALE = true;
    private static final Integer TEST_AMOUNT = 2;
    private static final Product TEST_PRODUCT;
    private static final ProductDto TEST_PRODUCT_DTO;
    private static final List<Product> TEST_PRODUCT_LIST = new ArrayList<>();
    private static final List<ProductDto> TEST_PRODUCT_DTO_LIST = new ArrayList<>();

    static {
        TEST_PRODUCT = new Product();
        TEST_PRODUCT.setId(TEST_ID);
        TEST_PRODUCT.setName(TEST_NAME);
        TEST_PRODUCT.setPrice(TEST_PRICE);
        TEST_PRODUCT.setSale(TEST_ISsALE);
        TEST_PRODUCT_LIST.add(TEST_PRODUCT);

        TEST_PRODUCT_DTO = new ProductDto(TEST_ID, TEST_AMOUNT);
        TEST_PRODUCT_DTO_LIST.add(TEST_PRODUCT_DTO);
    }

    @MockBean
    ProductMapper productMapper;
    @MockBean
    ProductRepository productRepository;

    @Test
    void testGetAll() {
        when(productRepository.findAll()).thenReturn(TEST_PRODUCT_LIST);
        when(productMapper.toDTOList(any())).thenReturn(TEST_PRODUCT_DTO_LIST);
        assertSame(TEST_PRODUCT_DTO_LIST, TEST_PRODUCT_LIST);
        verify(productRepository).findAll();
        verify(productMapper).toDTOList(any());
    }

    @Test
    void testGetById() {
        var ofResult = Optional.of(TEST_PRODUCT);
        when(productRepository.findById(any())).thenReturn(ofResult);
        when(productMapper.toDTO(any())).thenReturn(TEST_PRODUCT_DTO);
        var actualById = productRepository.getReferenceById(TEST_ID);
        assertSame(TEST_PRODUCT_DTO, actualById);
        assertEquals(TEST_PRICE, actualById.getPrice());
        verify(productRepository).findById(any());
        verify(productMapper).toDTO(any());
    }
}