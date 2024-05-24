package ru.otus.java.basic.homeworks.oop3.road.participant;

import ru.otus.java.basic.homeworks.oop3.road.common.Location;
import ru.otus.java.basic.homeworks.oop3.road.common.RoadUserCommon;
import ru.otus.java.basic.homeworks.oop3.road.common.Runner;
import ru.otus.java.basic.homeworks.oop3.road.common.Transport;

import java.util.Arrays;
import java.util.Objects;

public class Horse extends RoadUserCommon implements Transport, Runner {
    public static final int RUNNING_ENDURANCE_COST = 2;
    private int energy;

    private Human driver;

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

    @Override
    public boolean setDriver(Human human) {
        if(human == null) {
            System.out.println("Лошади нужен наездник");
            return false;
        }
        if (human.equals(driver)) {
            System.out.println(human.getName() + " уже верхом на лошади");
            return false;
        }
        if(human.getCurrentTransport() != null) {
            System.out.println(human.getName() + " уже управляет транспортом=" + human.getCurrentTransport());
            return false;
        }
        if (driver != null) {
            System.out.println("Лошадь занята другим наездником");
            return false;
        }
        driver = human;
        System.out.println("Лошадь оседлал " + human.getName());
        return true;
    }

    @Override
    public Human releaseDriver() {
        if(driver == null) {
            System.out.println("Лошадь уже свободна");
            return null;
        }
        Human human = driver;
        driver = null;
        System.out.println("Лошадь освободил наездник " + human.getName());
        return human;
    }

    @Override
    public Human getDriver() {
        return driver;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "energy=" + energy +
                ", driver=" + ((driver==null) ? null : driver.getName()) +
                ", invalidLocations=" + Arrays.toString(invalidLocations) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse horse)) return false;
        return energy == horse.energy && Objects.equals(driver, horse.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energy, driver);
    }
}
