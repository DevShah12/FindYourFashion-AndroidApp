package com.example.findyourfashion;

import java.util.ArrayList;

public class CartManager {

    private static CartManager instance;
    private final ArrayList<Product> cart;

    private CartManager() {
        cart = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public boolean isInCart(Product product) {
        return cart.contains(product);
    }
}
