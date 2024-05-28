package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.AutoCommon;
import ru.otus.java.basic.homeworks.oop3.road.common.Location;

import java.util.Arrays;

public class Car extends AutoCommon {
    public static final int AVERAGE_FUEL_CONSUMPTION = 10;

    public Car(int fuel) {
        super(fuel, new Location[]{Location.FOREST, Location.SWAMP});
    }

    @Override
    public boolean drive(int distance, Location location) {
        if (location == null) {
            System.out.println("Сначала опеределись с направлением движения");
            return false;
        }
        if (!isLocationSuitable(location)) {
            System.out.printf("Местность %s не для машины\n", location.getDescription());
            return false;
        }
        int requiredFuel = AVERAGE_FUEL_CONSUMPTION * distance / 100;
        if (requiredFuel > currentFuel) {
            System.out.printf("Машине не хватает топлива, доступно в баке=%dл, требуется для поездки=%dл\n", currentFuel, requiredFuel);
            return false;
        }
        currentFuel -= requiredFuel;
        System.out.printf("Машина проехала %dкм, потрачено %dл топлива, в баке осталось %dл\n", distance, requiredFuel, currentFuel);
        return true;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "driver=" + ((driver == null) ? null : driver.getName()) +
                ", maxFuel=" + maxFuel +
                ", currentFuel=" + currentFuel +
                ", invalidLocations=" + Arrays.toString(invalidLocations) +
                '}';
    }
}
