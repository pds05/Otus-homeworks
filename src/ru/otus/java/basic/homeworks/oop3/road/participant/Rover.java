package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.AutoCommon;
import ru.otus.java.basic.homeworks.oop3.road.common.Location;

import java.util.Arrays;

public class Rover extends AutoCommon {
    public static final int AVERAGE_FUEL_CONSUMPTION = 15;

    public Rover(int fuel) {
        super(fuel, null);
    }

    @Override
    public boolean drive(int distance, Location location) {
        int requiredFuel = AVERAGE_FUEL_CONSUMPTION * distance / 100;
        if (requiredFuel > currentFuel) {
            System.out.printf("Вездеходу не хватает топлива, доступно в баке=%dл, требуется для поездки=%dл\n", currentFuel, requiredFuel);
            return false;
        }
        currentFuel -= requiredFuel;
        System.out.printf("Вездеход проехал %dкм, потрачено %dл топлива, в баке осталось %dл\n", distance, requiredFuel, currentFuel);
        return true;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "driver=" + ((driver==null) ? null : driver.getName()) +
                ", maxFuel=" + maxFuel +
                ", currentFuel=" + currentFuel +
                ", invalidLocations=" + Arrays.toString(invalidLocations) +
                '}';
    }
}
