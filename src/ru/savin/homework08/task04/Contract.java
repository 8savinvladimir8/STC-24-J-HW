package ru.savin.homework08.task04;

public class Contract {
    private static int contractNumber = 1;
    private static String contractDate = "01.01.2020";
    private static String[] products = {"Чай","Газеты","Соль","Гвозди","Спички","Гречка"};

    public static int getContractNumber() {
        return contractNumber;
    }

    public static String getContractDate() {
        return contractDate;
    }

    public static String[] getProducts() {
        return products;
    }
}
