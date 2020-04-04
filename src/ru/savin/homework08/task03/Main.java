package ru.savin.homework08.task03;

public class Main {
    public static void main(String[] args) {
        ObjectCounter oc;

        for (int i = 1; i <= 5; i++) {
            oc = new ObjectCounter();
        }

        System.out.println("Создано объектов ObjectCounter: " + ObjectCounter.getObjectCount());
    }
}
