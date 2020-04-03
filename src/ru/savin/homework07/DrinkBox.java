package ru.savin.homework07;

import java.io.*;

/**
 * Класс имитирует автомат по продаже напитков
 */
public class DrinkBox {
    public static void main(String[] args) throws IOException {
        VendingMachine vm = new VendingMachine();
        vm.showContent();
        System.out.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isNotBought = true; // Признак - пока товар не куплен
        boolean isNeedToAddMoney = true;
        boolean isCanToChooseDrink = false;
        double cash;
        int productIndex;

        while (isNotBought) {
            if (isNeedToAddMoney) {
                System.out.println("Добавьте деньги для покупки:");
                cash = Double.parseDouble(reader.readLine());
                vm.addMoney(cash);
                if (vm.getCountOfMoney() > 0) {
                    System.out.println("В автомате: " + vm.getCountOfMoney() + " руб.");
                    isNeedToAddMoney = false;
                    isCanToChooseDrink = true;
                } else {
                    System.out.println("Денег в автомате недостаточно: " + vm.getCountOfMoney() + " руб.");
                    isNeedToAddMoney = true;
                    isCanToChooseDrink = false;
                }
            }

            if (isCanToChooseDrink) {
                System.out.println("Выберите номер напитка для покупки:");
                productIndex = Integer.parseInt(reader.readLine());
                if (vm.checkIfCorrectProductIndex(productIndex)) {
                    if (vm.checkIfMoneyEnoughToBuyProduct(productIndex)) {
                        vm.getProduct(productIndex);
                        if (vm.getCountOfMoney() > 0) {
                            System.out.println("Ваша сдача: " + vm.getCountOfMoney() + " руб.");
                        }
                        isNotBought = false;
                    } else {
                        isNeedToAddMoney = true;
                        isCanToChooseDrink = false;
                    }
                } else {
                    System.out.println("Введён некорректный номер напитка!");
                    System.out.println();
                    vm.showContent();
                    isNeedToAddMoney = false;
                    isCanToChooseDrink = true;
                }
            }
        }
        System.out.println("Спасибо, что воспользовались автоматом!");
    }
}
