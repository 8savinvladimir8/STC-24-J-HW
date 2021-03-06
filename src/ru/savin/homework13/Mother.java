package ru.savin.homework13;

import static ru.savin.homework13.Food.*;

/**
 * Класс имитирует кормление ребёнка
 * Суть задачи:
 * Написать программу "воспитанный ребенок".
 * Программа должна имитировать поведение воспитанного ребенка, которого мама кормит вкусной или невкусной едой. Если еда не нравится, ребенок ее не ест: выбрасывается исключительная ситуация, которая обрабатывается «мамой». Воспитанный ребенок, даже если еда не естся, в любом случае скажет «спасибо» и поцелует маму.
 *     Создать перечисление «Еда» с несколькими вариантами еды: морковь, яблоко, каша и т.д.
 *     Создать класс «ребенок» с методом «кушать», принимающий на вход некоторую еду. В методе происходит сравнение поступившей еды с вкусовыми предпочтениями и в случае если они не совпадают, выбрасывается исключение. «Одобренная» ребенком еда съедается: возвращается сообщение «съел … за обе щеки».
 *     Вне зависимости съел ребенок еду или выплюнул, ребенок благодарит маму, печатая в консоль «спасибо, мама».
 *     Создать главный класс и метод main - это будет «Мама». «Мама» дает ребенку «еду» и обрабатывает исключения ребенка.
 * @author Savin Vladimir
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
        System.out.println("Спасибо! Наелся на весь день.");
    }
}
