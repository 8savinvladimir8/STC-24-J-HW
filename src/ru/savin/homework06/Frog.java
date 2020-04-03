package ru.savin.homework06;

public class Frog extends Animal {
    public Frog() {
    }

    public Frog(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice () {
        System.out.println(super.getName() + " квакает");
    }
}
