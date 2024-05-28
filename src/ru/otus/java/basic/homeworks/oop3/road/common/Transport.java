package ru.otus.java.basic.homeworks.oop3.road.common;

import ru.otus.java.basic.homeworks.oop3.road.participant.Human;

public interface Transport {
    boolean drive(int distance, Location location);

    boolean fill(int fuel);

    boolean setDriver(Human human);

    Human releaseDriver();

    Human getDriver();

}

