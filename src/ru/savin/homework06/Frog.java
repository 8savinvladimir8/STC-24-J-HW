package ru.savin.homework06;

public class Frog extends Animal {
    @Override
    public void voice () {
        System.out.println(super.getName() + " квакает");
    }
}
