package com.academy.demoCheck.exception.card;

import com.academy.demoCheck.exception.ServiceException;

/**
 * @author : Volha Salash
 */

/**
 * class of exception thrown when a Discount Card service problem occurs
 */
public class DiscountCardServiceException extends ServiceException {

    public DiscountCardServiceException(String message) {
        super(message);
    }
}

