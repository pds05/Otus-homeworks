package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.*;

import java.util.Arrays;
import java.util.StringJoiner;

public class Human extends RoadUserCommon implements Driver, Runner {
    public static final int RUNNING_ENDURANCE_COST = 25;
    public static final int RIDING_BIKE_COST = 15;
    private String name;
    private Transport currentTransport;
    private Location currentLocation;
    private int energy;

    public Human(String name, int energy) {
        super(new Location[]{Location.SWAMP});
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return currentLocation;
    }

    @Override
    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    public int getPower() {
        return energy;
    }

    public boolean decreasePower(int power) {
        if (power < 0) {
            System.out.println("Человек должен работать, а не отдыхать!");
            return false;
        }
        if (power > energy) {
            System.out.println("Это непосильная работа для " + name);
        }
        energy -= power;
        System.out.printf("%s совершил работу, потрачено сил=%d, осталось сил=%d\n", name, power, energy);
        return true;
    }

    @Override
    public Transport getCurrentTransport() {
        return currentTransport;
    }

    @Override
    public boolean takeTransport(Transport transport) {
        if (transport == null) {
            System.out.println(name + " не получил транспорт");
            return false;
        }
        this.currentTransport = transport;
        System.out.println(name + " взял транспорт=" + transport);
        return true;
    }

    @Override
    public void releaseTransport() {
        currentTransport = null;
        System.out.println(name + " покинул транспорт");
    }

    @Override
    public boolean ride(int distance) {
        if (currentTransport == null) {
            System.out.printf("Ехать не на чем, %s пойдет пешком %dкм\n", name, distance);
            return run(distance, currentLocation);
        }
        return currentTransport.drive(distance, currentLocation);
    }

    @Override
    public boolean rest(int minutes) {
        if (minutes <= 0) {
            System.out.println("Для восстановления сил требуется время");
            return false;
        }
        this.energy += minutes * RUNNING_ENDURANCE_COST;
        System.out.println(name + " отдохнул: " + this);
        return true;
    }

    @Override
    public boolean run(int distance, Location location) {
        if (location == null) {
            System.out.println("Сначала опеределись с направлением движения");
            return false;
        }
        if (!isLocationSuitable(location)) {
            System.out.println(name + " не может пройти через " +
                    location.getDescription());
            return false;
        }
        int requiredEnergy = RUNNING_ENDURANCE_COST * distance;
        if (requiredEnergy > energy) {
            System.out.printf("Не хватает сил для передвижения на %dкм, пусть передохнет для восстановления сил\n", distance);
            return false;
        }
        energy -= requiredEnergy;
        System.out.printf("%s прошел %dкм\n", name, distance);
        return true;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Human.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("currentTransport=" + currentTransport)
                .add("currentLocation=" + currentLocation)
                .add("energy=" + energy)
                .add("invalidLocations=" + Arrays.toString(invalidLocations))
                .toString();
    }
}
