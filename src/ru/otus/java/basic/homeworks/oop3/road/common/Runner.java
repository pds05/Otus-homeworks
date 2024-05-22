package ru.otus.java.basic.homeworks.oop3.road.common;

public interface Runner {
    boolean run(int distance, Location location);

    boolean rest(int minutes);
}
