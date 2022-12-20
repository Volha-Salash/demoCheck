package com.academy.demoCheck.exception.product;

/**
 * @author : Volha Salash
 */

import com.academy.demoCheck.exception.ServiceException;

/**
 * class of exception thrown when a Product service problem occurs
 */
public class ProductServiceException  extends ServiceException {
        public ProductServiceException(String message) {
            super(message);
        }
    }