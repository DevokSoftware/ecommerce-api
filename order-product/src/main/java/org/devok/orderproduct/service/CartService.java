package org.devok.orderproduct.service;


import org.devok.orderproduct.model.Cart;

public interface CartService {
    void addProductToCart(String cartId, Long productId);
    void removeProductToCart(String cartId, Long productId);
    Cart getCart(String cartId);
    void deleteCart(String cartId);
}
