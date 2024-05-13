package ru.otus.java.basic.homeworks.oop2;

public class Horse extends Animal{
    public Horse(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
        this.swimmingEnduranceCost = 4;
    }
}
