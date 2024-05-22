package ru.otus.java.basic.homeworks.oop3.road;

import ru.otus.java.basic.homeworks.oop3.road.common.Location;
import ru.otus.java.basic.homeworks.oop3.road.common.Transport;
import ru.otus.java.basic.homeworks.oop3.road.participant.*;

public class RoadMain {
    public static void main(String[] args) {
        System.out.println("Создаем человека:");
        Human driver = new Human("Шумахер", 50);
        driver.info();
        driver.setLocation(Location.PLAIN);

        System.out.println("Создаем машину:");
        Transport carTransport = new Car(20);
        System.out.println(carTransport);

        driver.takeTransport(carTransport);
        driver.ride(200);

        System.out.println("Пробуем проехать еще. Заправляемся, если мало топлива");
        if (!driver.ride(100)) {
            carTransport.fill(10);
            driver.ride(100);
        }

        System.out.println("Пробуем проехать на машине по болоту");
        driver.setLocation(Location.SWAMP);
        driver.ride(100);

        System.out.println("Пересаживаем водителя из машины в вездеход...");
        driver.releaseTransport();

        System.out.println("Создаем вездеход:");
        Transport roverTransport = new Rover(30);
        System.out.println(roverTransport);

        driver.takeTransport(roverTransport);
        driver.info();

        if (!driver.ride(300)) {
            roverTransport.fill(15);
            driver.ride(300);
        }

        System.out.println("Теперь пересаживаем на лошадь...");
        driver.releaseTransport();

        System.out.println("Создаем лошадь:");
        Horse horse = new Horse(10);
        System.out.println(horse);

        System.out.println("Проверим, пойдет ли лошадь в болото...");
        driver.takeTransport(horse);
        if (!driver.ride(5)) {
            driver.setLocation(Location.FOREST);
        }
        if (!driver.ride(20)) {
            System.out.println("Чтобы лошадь одолела длинную дистанцию, пусть сначала поест,а затем отдохнет");
            horse.fill(5);
            driver.ride(20);

            horse.rest(10);
            driver.ride(20);
        }

        System.out.println("Пересаживаем наездника на велосипед...");
        driver.releaseTransport();

        System.out.println("Создаем велосипед:");
        Transport biecycle = new Biecycle(driver);

        driver.takeTransport(biecycle);
        driver.ride(2);
        System.out.println("Пробуем проехать еще. Если байкер устал, пусть передохнет и повторит попытку");
        if (!driver.ride(2)) {
            driver.rest(1);
            driver.ride(2);
        }

        System.out.println("Последний рывок до финиша, но пешком:");
        driver.releaseTransport();
        if (!driver.ride(1)) {
            driver.rest(1);
            driver.ride(1);
        }
    }
}
