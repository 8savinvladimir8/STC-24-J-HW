package ru.savin.homework07;

import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Класс имитирует автомат по продаже напитков
 */
public class DrinkBox {
    static final Logger log = LogManager.getLogger(DrinkBox.class.getName());

    public static void main(String[] args) throws IOException {
        VendingMachine vm = new VendingMachine();
        log.info("--------------------------------------------------");
        vm.showContent();
        log.info("");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isNotBought = true; // Признак - пока товар не куплен
        boolean isNeedToAddMoney = true;
        boolean isCanToChooseDrink = false;
        double cash;
        int productIndex;

        while (isNotBought) {
            if (isNeedToAddMoney) {
                log.info("Добавьте деньги для покупки:");
                cash = Double.parseDouble(reader.readLine());
                vm.addMoney(cash);
                if (vm.getCountOfMoney() > 0) {
                    log.info("В автомате: {} руб.",vm.getCountOfMoney());
                    isNeedToAddMoney = false;
                    isCanToChooseDrink = true;
                } else {
                    log.error("Денег в автомате недостаточно: {} руб.",vm.getCountOfMoney());
                    isNeedToAddMoney = true;
                    isCanToChooseDrink = false;
                }
            }

            if (isCanToChooseDrink) {
                log.info("Выберите номер напитка для покупки:");
                productIndex = Integer.parseInt(reader.readLine());
                if (vm.checkIfCorrectProductIndex(productIndex)) {
                    if (vm.checkIfMoneyEnoughToBuyProduct(productIndex)) {
                        vm.getProduct(productIndex);
                        if (vm.getCountOfMoney() > 0) {
                            log.info("Ваша сдача: {} руб.",vm.getCountOfMoney());
                        }
                        isNotBought = false;
                    } else {
                        isNeedToAddMoney = true;
                        isCanToChooseDrink = false;
                    }
                } else {
                    log.error("Введён некорректный номер напитка!");
                    log.error("");
                    vm.showContent();
                }
            }
        }
        log.info("Спасибо, что воспользовались автоматом!");
    }
}
