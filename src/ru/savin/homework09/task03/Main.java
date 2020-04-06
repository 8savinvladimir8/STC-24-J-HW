package ru.savin.homework09.task03;

public class Main {
    public static void main(String[] args) {
        Human[] athlete = {new RunnerAthlete("Бегун"),
                new SwimmerAthlete("Пловец"),
                new Pentathlete("Пятиборец")
        };
        for (int i = 0; i < athlete.length; i++) {
            System.out.println(athlete[i].getName() + " " + athlete[i].run() + ", " + athlete[i].swim());
        }
    }
}
