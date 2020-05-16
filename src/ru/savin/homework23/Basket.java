package ru.savin.homework23;

import java.util.List;

/**
 * Интерфейс {@code Basket} определяет функционал для реализации корзины интернет-магазина.
 */
public interface Basket {
    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProducts();

    int getProductQuantity(String product);
}
