package ru.otus.java.basic.homeworks.oop3.road.common;

public interface Transport {
    boolean drive(int distance, Location location);

    boolean fill(int fuel);
}