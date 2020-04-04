package ru.savin.homework08.task04;

public class DocumentConverter {
    public static void convertContract() {
        Act.setContractNumber(Contract.getContractNumber());
        Act.setContractDate(Contract.getContractDate());
        Act.setProducts(Contract.getProducts());
    }

    public static void main(String[] args) {
        DocumentConverter.convertContract();
        System.out.println("Акт №" + Act.getContractNumber() + " от \'" + Act.getContractDate() + "\' содержит товары:");
        for (int i = 1; i <= Act.getProducts().length - 1; i++) {
            System.out.println(i + ". " + Act.getProducts()[i]);
        }
    }
}
