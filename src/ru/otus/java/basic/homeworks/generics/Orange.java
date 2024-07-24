package ru.otus.java.basic.homeworks.generics;

public class Orange extends Fruit {
    public Orange(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Orange{" +
                super.toString() +
                "}";
    }
}
