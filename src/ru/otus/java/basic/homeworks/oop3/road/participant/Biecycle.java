package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.Location;
import ru.otus.java.basic.homeworks.oop3.road.common.RoadUserCommon;
import ru.otus.java.basic.homeworks.oop3.road.common.Transport;

import java.util.Arrays;

public class Biecycle extends RoadUserCommon implements Transport {
    private Human driver;

    public Biecycle(Human driver) {
        super(new Location[]{Location.SWAMP});
        this.driver = driver;
    }

    public Biecycle() {
        super(new Location[]{Location.SWAMP});
    }

    @Override
    public boolean drive(int distance, Location location) {
        if (location == null) {
            System.out.println("Сначала опеределись с направлением движения");
            return false;
        }
        if (!isLocationSuitable(location)) {
            System.out.println("Велосипед не может проехать через " +
                    location.getDescription());
            return false;
        }
        int requiredEnergy = Human.RIDING_BIKE_COST * distance;
        if (requiredEnergy > driver.getPower()) {
            System.out.printf("Велосипедисту не хватает сил для передвижения на %dкм, пусть передохнет для восстановления сил\n", distance);
            return false;
        }
        driver.decreasePower(requiredEnergy);
        System.out.printf("Велосипедист проехал %dкм\n", distance);
        return true;
    }

    @Override
    public boolean fill(int fuel) {
        System.out.println("Нельзя заправить велосипед, отправь передохнуть велосипедиста!");
        return false;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Biecycle{" +
                "invalidLocations=" + Arrays.toString(invalidLocations) +
                '}';
    }
}
