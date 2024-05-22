package ru.otus.java.basic.homeworks.oop3.road.common;

public class RoadUserCommon {

    protected Location[] invalidLocations;

    public RoadUserCommon(Location[] invalidLocations) {
        this.invalidLocations = invalidLocations;
    }

    public Location[] getInvalidLocations() {
        return invalidLocations;
    }

    public boolean isLocationSuitable(Location location) {
        if (invalidLocations == null) {
            return false;
        }
        for (Location l : invalidLocations) {
            if (l == location) {
                return false;
            }
        }
        return true;
    }
}
