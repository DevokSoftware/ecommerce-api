package org.devok.orderproduct.service;

import lombok.RequiredArgsConstructor;
import org.devok.orderproduct.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    @Override
    public void addProductToCart(String cartId, Long productId) {
        //TODO - Implement method
    }

    @Override
    public void removeProductToCart(String cartId, Long productId) {
        //TODO - Implement method
    }

    @Override
    public Cart getCart(String cartId) {
        //TODO - Implement method
        return null;
    }

    @Override
    public void deleteCart(String cartId) {
        //TODO - Implement method
    }
}
