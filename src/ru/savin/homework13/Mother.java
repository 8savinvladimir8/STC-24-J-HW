package ru.savin.homework13;

import static ru.savin.homework13.Food.*;

/**
 * Класс имитирует кормление ребёнка
 */
public class Mother {
    public static void main(String[] args) {
        Food[] food = {SOUP, SAUSAGE, PORRIDGE, APPLE, CARROT, PANCAKES};
        Child child = new Child();

        System.out.println("Кушай наздоровье, приятного аппетита!");
        System.out.println();
        for (Food f : food) {
            try {
                child.tasteDish(f);
            } catch (ChildDissatisfiedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        System.out.println("ВЫКАТЫВАЯСЬ ИЗ-ЗА СТОЛА: Спасибо! Наелся на весь день.");
    }
}
