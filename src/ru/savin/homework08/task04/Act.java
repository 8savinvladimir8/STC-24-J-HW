package ru.savin.homework08.task04;

public class Act {
    private static int contractNumber;
    private static String contractDate;
    private static String[] products;

    public static int getContractNumber() {
        return contractNumber;
    }

    public static void setContractNumber(int contractNumber) {
        Act.contractNumber = contractNumber;
    }

    public static String getContractDate() {
        return contractDate;
    }

    public static void setContractDate(String contractDate) {
        Act.contractDate = contractDate;
    }

    public static String[] getProducts() {
        return products;
    }

    public static void setProducts(String[] products) {
        Act.products = products;
    }
}
