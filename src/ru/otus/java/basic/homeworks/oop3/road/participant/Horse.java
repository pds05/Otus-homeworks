package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.RoadUserCommon;
import ru.otus.java.basic.homeworks.oop3.road.common.Runner;
import ru.otus.java.basic.homeworks.oop3.road.common.Location;
import ru.otus.java.basic.homeworks.oop3.road.common.Transport;

import java.util.Arrays;
import java.util.StringJoiner;

public class Horse extends RoadUserCommon implements Transport, Runner {
    public static final int RUNNING_ENDURANCE_COST = 2;
    private int energy;

    public Horse(int energy) {
        super(new Location[]{Location.SWAMP});
        this.energy = energy;
    }

    @Override
    public boolean run(int distance, Location location) {
        if (location == null) {
            System.out.println("Сначала опеределись с направлением движения");
            return false;
        }
        if (!isLocationSuitable(location)) {
            System.out.println("Лошадь не может пройти через " +
                    location.getDescription());
            return false;
        }
        int requiredEnergy = RUNNING_ENDURANCE_COST * distance;
        if (requiredEnergy > energy) {
            System.out.printf("Лошади не хватает сил для передвижения на %dкм, "
                    + "пусть передохнет или поест для восстановления сил, "
                    + "запас сил=%d, требуется сил=%d \n", distance, energy, requiredEnergy);
            return false;
        }
        energy -= requiredEnergy;
        System.out.printf("Лошадь преодолела %dкм\n", distance);
        return true;
    }

    @Override
    public boolean rest(int minutes) {
        if (minutes <= 0) {
            System.out.println("Для восстановления сил требуется время");
            return false;
        }
        this.energy += minutes * RUNNING_ENDURANCE_COST;
        System.out.println("Лошадь отдохнула:" + this);
        return true;
    }

    @Override
    public boolean drive(int distance, Location locale) {
        return run(distance, locale);
    }

    @Override
    public boolean fill(int food) {
        if (food <= 0) {
            System.out.println("Чтобы пополнить запас сил нужна еда");
            return false;
        }
        this.energy += food * RUNNING_ENDURANCE_COST;
        System.out.println("Лошадь поела:" + this);
        return true;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Horse.class.getSimpleName() + "[", "]")
                .add("energy=" + energy)
                .add("invalidLocations=" + Arrays.toString(invalidLocations))
                .toString();
    }
}
