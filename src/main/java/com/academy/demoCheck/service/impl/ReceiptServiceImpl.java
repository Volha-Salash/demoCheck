package com.academy.demoCheck.service.impl;

import com.academy.demoCheck.exception.product.ProductServiceException;
import com.academy.demoCheck.model.dto.console.CheckConsoleDto;
import com.academy.demoCheck.model.dto.console.ProductConsoleDto;
import com.academy.demoCheck.model.entity.DiscountCard;
import com.academy.demoCheck.model.entity.Receipt;
import com.academy.demoCheck.model.entity.ReceiptProduct;
import com.academy.demoCheck.repository.DiscountCardRepository;
import com.academy.demoCheck.repository.ProductRepository;
import com.academy.demoCheck.service.interfaces.ReceiptService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Volha Salash
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptServiceImpl implements ReceiptService {

    private final DiscountCardRepository discountCardRepository;
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

    @Override
    public Receipt createReceipt(CheckConsoleDto checkDto) {

        Receipt receipt = new Receipt();

        Optional<DiscountCard> optionalDiscountCard = checkDto.getDiscountCardNumber() == null
                ? Optional.empty()
                : discountCardRepository.findByNumber(checkDto.getDiscountCardNumber());

        List<ReceiptProduct> productList = new ArrayList<>();

        for (ProductConsoleDto productDto : checkDto.getProducts()) {
            try {
                productRepository.findById(productDto.getId()).ifPresent(product -> {
                    ReceiptProduct receiptProduct = new ReceiptProduct();
                    receiptProduct.setProduct(product);
                    receiptProduct.setAmount(productDto.getAmount());
                    receiptProduct.setDiscountSum(BigDecimal.ZERO);
                    productList.add(receiptProduct);
                });
            } catch (ProductServiceException e) {
                throw new ProductServiceException (messageSource.getMessage("msg.error.product.find.by.id", null,
                        LocaleContextHolder.getLocale()));
            }
        }

        productList.forEach(receiptProduct -> receiptProduct
                .setTotalSum(receiptProduct.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(receiptProduct.getAmount()))));

        productList.stream()
                .filter(receiptProduct -> receiptProduct.getProduct().isSale() && receiptProduct.getAmount() > 5)
                .forEach(receiptProduct -> receiptProduct.setDiscountSum(
                        receiptProduct.getTotalSum().multiply(new BigDecimal("0.1"))));

        optionalDiscountCard.ifPresent(discountCard -> {
            productList.stream()
                    .filter(receiptProduct -> !receiptProduct.getProduct().isSale())
                    .forEach(receiptProduct -> receiptProduct.setDiscountSum(
                            receiptProduct.getTotalSum().multiply(discountCard.getDiscount())));
        });

        productList.forEach(receiptProduct -> receiptProduct.setTotalSumWithDiscount(
                receiptProduct.getTotalSum().subtract(receiptProduct.getDiscountSum())));

        receipt.setProducts(productList);
        receipt.setDiscountCard(optionalDiscountCard.orElse(null));
        receipt.setDate(LocalDate.now());
        receipt.setTime(LocalTime.now());
        receipt.setTotalSum(productList.stream()
                .map(ReceiptProduct::getTotalSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        receipt.setDiscountSum(productList.stream()
                .map(ReceiptProduct::getDiscountSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        receipt.setTotalSumWithDiscount(productList.stream()
                .map(ReceiptProduct::getTotalSumWithDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return receipt;
    }
}


//если ном карты не налл, получить карту из репозитория, если нал, то в модель ресипт сетаем налл
//из листа стрим, мэп у стрима, для каждого итм достаем по ай ди продакт ,сетаем его в ресипт продакт модель
//сетаем эмаунт из дто в модель
//расчеты) цена*количество, сумма скидки, сумма со скидкой
//проверка акционный, если флаг тру и колво больше 5, то скидка 10% (тогда без диск.карты) -> не акционные скидка по карте, если есть, сетаем сумму скидки, потом сумму со скидкой посчитать
//реторн модели из мэпа
//получаем лист ресипт айтм, который сетаем в ресипт
