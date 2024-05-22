package ru.otus.java.basic.homeworks.oop3.road.common;

public abstract class AutoCommon extends RoadUserCommon implements Transport {
    protected int maxFuel;
    protected int currentFuel;

    public AutoCommon(int fuel, Location[] invalidLocations) {
        super(invalidLocations);
        this.maxFuel = fuel;
        this.currentFuel = fuel;
    }

    public boolean fill(int fuel) {
        if (fuel <= 0) {
            System.out.println("Не хватает топлива для заправки");
        }
        if (fuel > maxFuel) {
            System.out.printf("Топливо перельется! Заправь не более %s литров \n", maxFuel);
            return false;
        }
        this.currentFuel += fuel;
        System.out.printf("%s заправился на %s литров: %s \n", this.getClass().getSimpleName(), fuel, this);
        return true;

    }
}
