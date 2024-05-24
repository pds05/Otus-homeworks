package ru.otus.java.basic.homeworks.oop3.road.common;

public interface Driver {
    boolean ride(int distance);

    boolean takeTransport(Transport transport);

    Transport releaseTransport();

    Transport getCurrentTransport();

    void setLocation(Location location);

    Location getLocation();
}
