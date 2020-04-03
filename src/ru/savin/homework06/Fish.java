package ru.savin.homework06;

public class Fish extends Animal {
    public Fish() {
    }

    public Fish(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice () {
        System.out.println(super.getName() + " молчит");
    }
}
