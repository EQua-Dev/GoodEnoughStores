/*
 * Copyright (c) 2024.
 * Richard Uzor
 * Under Awesomeness Studios
 */

package com.awesomenessstudios.goodenoughstores.services.cart;

import com.awesomenessstudios.goodenoughstores.exceptions.ResourceNotFoundException;
import com.awesomenessstudios.goodenoughstores.models.Cart;
import com.awesomenessstudios.goodenoughstores.models.CartItem;
import com.awesomenessstudios.goodenoughstores.repositories.CartItemRepository;
import com.awesomenessstudios.goodenoughstores.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService{

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);

        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getCartItems().clear();
        cartRepository.deleteById(id);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);

        return cart.getTotalAmount();
    }
}
