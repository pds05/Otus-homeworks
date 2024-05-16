package ru.otus.java.basic.homeworks.oop2;

public class Dog extends Animal{
    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
        this.swimmingEnduranceCost = 2;
    }
}
