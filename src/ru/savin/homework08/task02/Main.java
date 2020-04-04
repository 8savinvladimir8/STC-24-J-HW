package ru.savin.homework08.task02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Суммирование 1 + 2 = " + Calculator.summation(1,2));
        System.out.println("Суммирование 1.3 + 2.4 = " + Calculator.summation(1.3,2.4));

        System.out.println("Вычитание 3 - 1 = " + Calculator.subtraction(3,1));
        System.out.println("Вычитание 3.2 - 1.1 = " + Calculator.subtraction(3.2,1.1));

        System.out.println("Умножение 2 * 2 = " + Calculator.multiplication(2,2));
        System.out.println("Умножение 2.1 * 2.3 = " + Calculator.multiplication(2.1,2.3));

        System.out.println("Деление 8 / 4 = " + Calculator.division(8,4));
        System.out.println("Деление 8.3 / 3.1 = " + Calculator.division(8.3,3.1));

        System.out.println("Процент 5 от 20 = " + Calculator.percentage(5,20) + "%");
        System.out.println("Процент 7 от 14 = " + Calculator.percentage(7,14) + "%");
    }
}
