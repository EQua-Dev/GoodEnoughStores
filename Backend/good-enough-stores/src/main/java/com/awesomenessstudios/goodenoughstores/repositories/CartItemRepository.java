/*
 * Copyright (c) 2024.
 * Richard Uzor
 * Under Awesomeness Studios
 */

package com.awesomenessstudios.goodenoughstores.repositories;

import com.awesomenessstudios.goodenoughstores.models.Cart;
import com.awesomenessstudios.goodenoughstores.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository  extends JpaRepository<CartItem, Long> {
    void deleteAllByCartId(Long id);
}
