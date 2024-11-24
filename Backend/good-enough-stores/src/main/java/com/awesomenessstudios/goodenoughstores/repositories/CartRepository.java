/*
 * Copyright (c) 2024.
 * Richard Uzor
 * Under Awesomeness Studios
 */

package com.awesomenessstudios.goodenoughstores.repositories;

import com.awesomenessstudios.goodenoughstores.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
