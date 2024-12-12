package ru.otus.java.basic.homeworks.oop2;

public class Cat extends Animal{
    public Cat(String name, int runningSpeed, int endurance) {
        super(name, runningSpeed, 0, endurance);
    }

    @Override
    public float swim(int distance) {
        System.out.println("ERROR: cats don`t swim");
        return -99;
    }
}
