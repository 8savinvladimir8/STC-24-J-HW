package ru.savin.homework09.task01;

import ru.savin.homework09.task02.Flyable;
import ru.savin.homework09.task02.Runable;
import ru.savin.homework09.task02.Swimable;
import ru.savin.homework09.task03.Human;
import ru.savin.homework09.task03.Pentathlete;
import ru.savin.homework09.task03.RunnerAthlete;
import ru.savin.homework09.task03.SwimmerAthlete;

public class Main {
    public static void main(String[] args) {
        // task01
        Dog dog = new Dog();
        dog.getName();
        Duck duck = new Duck();
        duck.getName();
        Fish fish = new Fish();
        fish.getName();
        System.out.println();

        // task02
        Flyable[] fly = {new Duck()};
        String flyers = "Летающие животные: ";
        for (int i = 0; i < fly.length; i++) {
            flyers += fly[i].fly();
            if (i < fly.length - 1) flyers += ", ";
        }
        System.out.println(flyers);

        Runable[] run = {new Dog(), new Duck()};
        String runners = "Бегающие животные: ";
        for (int i = 0; i < run.length; i++) {
            runners += run[i].run();
            if (i < run.length - 1) runners += ", ";
        }
        System.out.println(runners);

        Swimable[] swim = {new Duck(), new Fish()};
        String swimmers = "Плавающие животные: ";
        for (int i = 0; i < swim.length; i++) {
            swimmers += swim[i].swim();
            if (i < swim.length - 1) swimmers += ", ";
        }
        System.out.println(swimmers);
        System.out.println();

        // task03
        Human[] athlete = {new RunnerAthlete("Бегун"),
                new SwimmerAthlete("Пловец"),
                new Pentathlete("Пятиборец")
        };
        for (int i = 0; i < athlete.length; i++) {
            System.out.println(athlete[i].getName() + " " + athlete[i].run() + ", " + athlete[i].swim());
        }
    }
}
