package ru.otus.java.basic.homeworks.generics;

public class Apple extends Fruit {
    public Apple(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                super.toString() +
                "}";
    }
}
