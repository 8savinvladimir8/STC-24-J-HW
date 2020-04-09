package ru.savin.homework08.task04;

/**
 * Класс конвертирует договор в акт
 */
public class DocumentConverter {
    public static Act convertContract(Contract contract, String employer) {
        Act act = new Act();
        act.setContractNumber(contract.getContractNumber());
        act.setContractDate(contract.getContractDate());
        act.setProducts(contract.getProducts());
        act.setEmployer(employer);
        return act;
    }

    public static void main(String[] args) {
        String[] products = {"Чай","Газеты","Соль","Гвозди","Спички","Гречка"};
        Contract contract = new Contract(123,"01.01.2020",products);
        Act act1 = convertContract(contract,"Иванов");
        System.out.println(act1.toString());
        products = new String[]{"Часы", "Смартфоны", "Ноутбки", "Планшеты"};
        contract = new Contract(321,"02.02.2020",products);
        Act act2 = convertContract(contract,"Петров");
        System.out.println(act2.toString());
    }
}
