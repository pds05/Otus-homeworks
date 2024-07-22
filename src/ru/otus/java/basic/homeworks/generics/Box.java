package ru.otus.java.basic.homeworks.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruitsList = new ArrayList<>();

    public List<T> getFruits() {
        return fruitsList;
    }

    public void put(List<T> fruits) {
        fruitsList.addAll(fruits);
    }

    public void put(T fruit) {
        fruitsList.add(fruit);
    }

    public int getBoxWeight() {
        return fruitsList.stream().mapToInt(Fruit::getWeight).sum();
    }

    public boolean compare(Box box) {
        return this.getBoxWeight() == box.getBoxWeight();
    }

    public void move(Box<T> box) {
        fruitsList.addAll(box.getFruits());
    }
}
