package ru.savin.homework06;

/**
 * Класс имитирует пруд, заселённый животными
 */
public class Pond {

    public static void main(String[] args) {
	    Animal frog = new Frog();
	    frog.setName("Обыкновенная квакша");
	    frog.setColor("зелёный");
        System.out.println("В пруду водится лягушка: " + frog.getName());
	    frog.voice();
        System.out.println("Цвет кожи: " + frog.getColor());
        System.out.println("");

        Animal duck = new Duck();
        duck.setName("Кряква");
        duck.setColor("серый");
        System.out.println("В пруду водится утка: " + duck.getName());
        duck.voice();
        System.out.println("Цвет перьев: " + duck.getColor());
        System.out.println("");

        Animal fish = new Fish();
        fish.setName("Карась");
        fish.setColor("серебристый");
        System.out.println("В пруду водится рыба: " + fish.getName());
        fish.voice();
        System.out.println("Цвет чешуи: " + fish.getColor());
    }
}
