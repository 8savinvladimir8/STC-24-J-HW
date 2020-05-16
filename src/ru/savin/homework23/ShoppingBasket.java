package ru.savin.homework23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/**
 * Класс {@code ShoppingBasket} является реализацией интерфейса {@code Basket}.
 * Методы данного класса реализуют функционал корзины интернет-магазина.
 * @author Savin Vladimir
 */
public class ShoppingBasket implements Basket {
    static final Logger log = LogManager.getLogger(ShoppingBasket.class.getName());
    private static final String EMPTY_BASKET = "Корзина пуста. Пожалуйста добавьте товары.";
    private final ArrayList<String> productsList;

    public ShoppingBasket() {
        productsList = new ArrayList<>();
    }

    /**
     * Метод добавляет указанное количество товара в корзину интернет-магазина.
     * @param product содержит наименование нового товара, который нужно добавить в корзину.
     * @param quantity содержит количество нового товара, который нужно добавить в корзину.
     */
    public void addProduct(String product, int quantity) {
        if (containsIgnoreCase(productsList, product)) {
            log.error("Товар '{}' уже добавлен в корзину. Если требуется, то измените его количество.",
                    getProductNameInBasket(productsList, product));

        } else if (quantity <= 0) {
            log.error("Нулевое или отрицательное количества товара недопустимо.");

        } else {
            productsList.ensureCapacity(productsList.size() + quantity);
            for (int i = 1; i <= quantity; i++) {
                productsList.add(product);
            }
            log.info("Добавлен товар '{}' в количестве {}", product, quantity);
        }
    }

    /**
     * Метод удаляет все единиы указанного товара из корзины.
     * @param product содержит наименование удаляемого из корзины товара.
     */
    public void removeProduct(String product) {
        if (productsList.isEmpty()) {
            log.error(EMPTY_BASKET);

        } else if (!containsIgnoreCase(productsList, product)) {
            log.error("Товар '{}' не найден в корзине.", product);

        } else {
            String productNameInBasket = "";
            Iterator<String> productIterator = productsList.iterator();
            while (productIterator.hasNext()) {
                String prod = productIterator.next();
                if (prod.equalsIgnoreCase(product)) {
                    productNameInBasket = getProductNameInBasket(productsList, product);
                    productIterator.remove();
                }
            }
            log.info("Товар '{}' удалён из корзины", productNameInBasket);
        }
    }

    /**
     * Метод меняет количество, содержащегося в корзине товара, на указанную величину.
     * Т.е. содержащееся в корзине количество указанного товара изменяется на разницу
     * между текущим количеством товара и новым указанным количеством товара.
     * @param product содержит наименование товара, количество которого нужно изменить.
     * @param quantity содержит новое количество указанного товара.
     */
    public void updateProductQuantity(String product, int quantity) {
        if (productsList.isEmpty()) {
            log.error(EMPTY_BASKET);

        } else if (quantity <= 0) {
            log.error("Нулевое или отрицательное количества товара недопустимо.");

        } else if (!containsIgnoreCase(productsList, product)) {
            log.error("Товар '{}' не найден в корзине.", product);

        } else {
            int productCount = getProductQuantity(product);

            if (productCount < quantity) {
                for (int i = 0; i < quantity - productCount; i++) {
                    productsList.add(getProductNameInBasket(productsList, product));
                }
                log.info("Количество товара '{}' в корзине увеличено до {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);

            } else if (productCount > quantity) {
                int productCountToRemove = productCount - quantity;
                for (Iterator<String> i = productsList.iterator(); i.hasNext() && productCountToRemove > 0;) {
                    String prod = i.next();
                    if (prod.equalsIgnoreCase(product)) {
                        i.remove();
                        productCountToRemove--;
                    }
                }
                log.info("Количество товара '{}' в корзине уменьшено до {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);

            } else {
                log.error("Количество товара '{}' в корзине уже равно {}.",
                        getProductNameInBasket(productsList, product),
                        quantity);
            }
        }
    }

    /**
     * Метод полностью очищает корзину от хранящихся в ней товаров.
     */
    public void clear() {
        if (productsList.isEmpty()) {
            log.error("Корзина уже пуста.");
        } else {
            productsList.clear();
            log.info("Корзина очищена от товаров.");
        }
    }

    /**
     * Метод возвращает коллекцию товаров, хранящихся в корзине.
     * @return коллекцию товаров, хранящихся в корзине.
     */
    public List<String> getProducts() {
        return productsList;
    }

    /**
     * Метод возвращает количество указанного товара, хранящегося в корзине.
     * @param product наименование товара, для которого нужно вернуть его количество, хранящееся в корзине.
     * @return количество указанного товара, хранящегося в корзине.
     */
    public int getProductQuantity(String product) {
        if (!containsIgnoreCase(productsList, product)) {
            return 0;
        }
        int productCount = 0;
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                productCount++;
            }
        }
        return productCount;
    }

    /**
     * Метод проверяет наличие в коллекции указанного товара, независимо от того,
     * в каком регистре введены буквы наименования этого товара.
     * @param productsList коллекция, в которой проверяется наличие товара.
     * @param product наименование товара, наличие которого проверяется указанной в коллекции.
     * @return true, если товар найден в указанной коллекции; false, если товар в указанной коллекции не найден.
     */
    public boolean containsIgnoreCase(List<String> productsList, String product) {
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает наименование товара в том регистре, в каком он хранится в указанной коллекции.
     * @param productsList коллекция, из которой извлекается наименование указанного товара.
     * @param product товар, для которого из коллекции нужно извлечь хранящееся наименование.
     * @return наименование товара в регистре, в котором он хранится в указанной коллекции.
     */
    public String getProductNameInBasket(List<String> productsList, String product) {
        for (String s : productsList) {
            if (s.equalsIgnoreCase(product)) {
                return s;
            }
        }
        return "";
    }

    /**
     * Метод выводит хранящиеся в корзине товары (наименование и количество) в виде таблицы.
     * @param productsList коллекция, товары которой нужно вывести.
     */
    public void showProducts(List<String> productsList) {
        if (productsList.isEmpty()) {
            log.error(EMPTY_BASKET);

        } else {
            log.info("Товары в корзине:");
            printProductString("Товар", "Количество");
            printProductString("====================", "==========");
            List<String> products = new ArrayList<>();
            for (String s : productsList) {
                if (!containsIgnoreCase(products, s)) {
                    products.add(s);
                    printProductString(s, String.valueOf(getProductQuantity(s)));
                }
            }
        }
    }

    /**
     * Метод задаёт формат строки выводимого товара (наименования и количества).
     * Также метод выводит строки заголовка столбцов и разделители.
     * @param product наименование выводимого товара.
     * @param count количество выводимого товара.
     */
    public void printProductString(String product, String count) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%-20.20s%10.10s", product, count);
            log.info(productFormatter);
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}