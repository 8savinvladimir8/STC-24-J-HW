package ru.savin.homework23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс {@code MyShopping} демонстрирует работу с корзиной интернет-магазина.
 * Суть задачи:
 * Реализовать класс корзины интернет магазина по следующему интерфейсу:
 * interface Basket {
 *     void addProduct(String product, int quantity);
 *     void removeProduct(String product);
 *     void updateProductQuantity(String product, int quantity);
 *     void clear();
 *     List<String> getProducts();
 *     int getProductQuantity(String product);
 * }
 * @author Savin Vladimir
 */
public class MyShopping {
    static final Logger log = LogManager.getLogger(MyShopping.class.getName());

    /**
     * Точка входа.
     * @param args содержит аргументы командной строки.
     */
    public static void main(String[] args) {
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                log.info("");
                log.info("Введите № операции (exit для выхода):");
                log.info("1 - показать товары в корзине");
                log.info("2 - добавить товар в корзину");
                log.info("3 - изменить количество товара в корзине");
                log.info("4 - удалить товар из корзины");
                log.info("5 - очистить корзину");

                String line = br.readLine();
                if (line.equals("exit")) return;

                String name = "";
                int count = 0;

                switch (line) {
                    case "1":
                        shoppingBasket.showProducts(shoppingBasket.getProducts());
                        break;
                    case "2":
                        log.info("Введите наименование товара, который нужно добавить:");
                        name = br.readLine();
                        log.info("Введите количество добавляемого товара:");
                        count = Integer.parseInt(br.readLine());
                        shoppingBasket.addProduct(name, count);
                        break;
                    case "3":
                        log.info("Введите наименование товара, количество которого нужно изменить:");
                        name = br.readLine();
                        log.info("Введите новое количество товара:");
                        count = Integer.parseInt(br.readLine());
                        shoppingBasket.updateProductQuantity(name, count);
                        break;
                    case "4":
                        log.info("Введите наименование товара, который нужно удалить:");
                        name = br.readLine();
                        shoppingBasket.removeProduct(name);
                        break;
                    case "5":
                        shoppingBasket.clear();
                        break;
                    default:
                        log.error("Введён некорректный номер операции");
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
