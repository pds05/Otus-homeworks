package ru.otus.java.basic.homeworks.oop3.road.common;

public enum Location {
    FOREST("густой лес"), PLAIN("равнина"), SWAMP("болото");

    private final String description;

    Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
