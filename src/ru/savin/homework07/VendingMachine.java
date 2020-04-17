package ru.savin.homework07;

import static ru.savin.homework07.Drinks.*;

public class VendingMachine {
    private double money = 0;
    private Drinks[] drinks;

    public VendingMachine() {
        drinks = new Drinks[] {WATER, JUICE, TEA, COFFEE, WATER};
    }

    public void showContent() {
        for (int i = 0; i < drinks.length; i++) {
            DrinkBox.log.info("Товар № " + i + " - " + drinks[i].toString());
        }
    }

    public double getCountOfMoney() {
        return money;
    }

    public void addMoney(double money) {
        if (money > 0)
            this.money += money;
    }

    public boolean checkIfCorrectProductIndex(int productIndex) {
            if (productIndex >= 0 && productIndex <= drinks.length - 1) {
                return true;
            } else {
                return false;
            }
    }

    public boolean checkIfMoneyEnoughToBuyProduct(int productIndex) {
        if (money < Drinks.getDrinkPrice(drinks[productIndex])) {
            DrinkBox.log.error("Внесено недостаточно денег: " + money + " руб.");
            return false;
        } else {
            return true;
        }
    }

    public void getProduct(int productIndex) {
        money -= Drinks.getDrinkPrice(drinks[productIndex]);
        DrinkBox.log.info("Куплен товар № " + productIndex + " - " + drinks[productIndex].toString());
        drinks[productIndex] = EMPTY;
    }
}
