package ru.savin.homework08.task03;

public class ObjectCounter {
    private static int objectCount = 0;

    public ObjectCounter() {
        objectCount++;
    }

    public static int getObjectCount() {
        return objectCount;
    }
}
