package ru.otus.java.basic.homeworks.oop3.road.common;

import ru.otus.java.basic.homeworks.oop3.road.participant.Human;

import java.util.Objects;

public abstract class AutoCommon extends RoadUserCommon implements Transport {
    protected Human driver;
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
            System.out.printf("Топливо перельется! Заправь не более %s литров\n", maxFuel);
            return false;
        }
        this.currentFuel += fuel;
        System.out.printf("%s заправился на %s литров: %s\n", this.getClass().getSimpleName(), fuel, this);
        return true;
    }

    @Override
    public Human getDriver() {
        return driver;
    }

    @Override
    public boolean setDriver(Human human) {
        if (human == null) {
            System.out.printf("Транспорту %s нужен водитель\n", this.getClass().getSimpleName());
            return false;
        }
        if (human.equals(driver)) {
            System.out.println(human.getName() + " уже сидит в этом транспорте=" + this);
            return false;
        }
        if (human.getCurrentTransport() != null) {
            System.out.println(human.getName() + " уже сидит в другом транспорте=" + human.getCurrentTransport());
            return false;
        }
        if (driver != null) {
            System.out.println("Место занято другим водителем");
            return false;
        }
        driver = human;
        System.out.printf("В транспорт %s сел водитель %s\n", this.getClass().getSimpleName(), human.getName());
        return true;
    }

    @Override
    public Human releaseDriver() {
        if (driver == null) {
            System.out.println("Транспорт без водителя");
            return null;
        }
        Human human = driver;
        driver = null;
        System.out.printf("Транспорт %s покинул водитель %s\n", this.getClass().getSimpleName(), human.getName());
        return human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoCommon that)) return false;
        return maxFuel == that.maxFuel && currentFuel == that.currentFuel && Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, maxFuel, currentFuel);
    }
}
