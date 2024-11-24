/*
 * Copyright (c) 2024.
 * Richard Uzor
 * Under Awesomeness Studios
 */

package com.awesomenessstudios.goodenoughstores.services.cart;

import com.awesomenessstudios.goodenoughstores.models.Cart;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
}
