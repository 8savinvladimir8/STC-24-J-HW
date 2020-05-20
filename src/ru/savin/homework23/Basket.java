package ru.savin.homework23;

import java.util.List;

/**
 * Интерфейс {@code Basket} определяет функционал для реализации корзины интернет-магазина.
 */
public interface Basket {
    /**
     * Метод добавляет указанное количество товара в корзину интернет-магазина.
     * @param product содержит наименование нового товара, который нужно добавить в корзину.
     * @param quantity содержит количество нового товара, который нужно добавить в корзину.
     */
    void addProduct(String product, int quantity);

    /**
     * Метод удаляет все единиы указанного товара из корзины.
     * @param product содержит наименование удаляемого из корзины товара.
     */
    void removeProduct(String product);

    /**
     * Метод меняет количество, содержащегося в корзине товара, на указанную величину.
     * Т.е. содержащееся в корзине количество указанного товара изменяется на разницу
     * между текущим количеством товара и новым указанным количеством товара.
     * @param product содержит наименование товара, количество которого нужно изменить.
     * @param quantity содержит новое количество указанного товара.
     */
    void updateProductQuantity(String product, int quantity);

    /**
     * Метод полностью очищает корзину от хранящихся в ней товаров.
     */
    void clear();

    /**
     * Метод возвращает коллекцию товаров, хранящихся в корзине.
     * @return коллекцию товаров, хранящихся в корзине.
     */
    List<String> getProducts();

    /**
     * Метод возвращает количество указанного товара, хранящегося в корзине.
     * @param product наименование товара, для которого нужно вернуть его количество, хранящееся в корзине.
     * @return количество указанного товара, хранящегося в корзине.
     */
    int getProductQuantity(String product);
}
