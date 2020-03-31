package ru.savin.homework06;

public class Fish extends Animal {
    @Override
    public void voice () {
        System.out.println(super.getName() + " молчит");
    }
}
