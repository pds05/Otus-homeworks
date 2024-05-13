package ru.otus.java.basic.homeworks.oop2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Animal {
    private String name;
    private int runningSpeed;
    private int swimmingSpeed;
    private int endurance;
    protected int runningEnduranceCost = 1;
    protected int swimmingEnduranceCost;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public float run(int distance) {
        int requiredEndurance = distance * runningEnduranceCost;
        if (endurance < requiredEndurance) {
            System.out.println("WARNING: " + this.getClass().getSimpleName() + " " + name
                    + " tired to run " + distance + " meters. Endurance is not enough: endurance=" + endurance
                    + ", requiredEndurance=" + requiredEndurance);
            return -1;
        }
        endurance = endurance - requiredEndurance;
        float timeSec = new BigDecimal((float) distance / runningSpeed).setScale(2, RoundingMode.HALF_DOWN).floatValue();
        System.out.println(this.getClass().getSimpleName() + " " + name
                + " ran " + distance + " meters distance in " + timeSec + " seconds");
        return timeSec;
    }

    public float swim(int distance) {
        int requiredEndurance = distance * swimmingEnduranceCost;
        if (endurance < requiredEndurance) {
            System.out.println("WARNING: " + this.getClass().getSimpleName() + " " + name
                    + " tired to swim " + distance  + " meters. Endurance is not enough: endurance=" + endurance
                    + ", requiredEndurance=" + requiredEndurance);
            return -1;
        }
        endurance = endurance - requiredEndurance;
        float timeSec = new BigDecimal((float) distance / swimmingSpeed).setScale(2, RoundingMode.HALF_DOWN).floatValue();
        System.out.println(this.getClass().getSimpleName() + " " + name
                + " swam " + distance + " meters distance in " + timeSec + " seconds");
        return timeSec;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", runningSpeed=" + runningSpeed +
                ", swimmingSpeed=" + swimmingSpeed +
                ", endurance=" + endurance +
                ", runningEnduranceCost=" + runningEnduranceCost +
                ", swimmingEnduranceCost=" + swimmingEnduranceCost +
                '}';
    }

    public void info() {
        System.out.println(toString());
    }
}
