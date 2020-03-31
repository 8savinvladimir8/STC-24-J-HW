package ru.savin.homework06;

public class Duck extends Animal {
    @Override
    public void voice () {
        System.out.println(super.getName() + " крякает");
    }
}
