package ru.otus.java.basic.homeworks.oop2;

public class AnimalsMain {
    public static void main(String[] args) {
        System.out.println("The cat is ready:");
        Cat cat = new Cat("Barsik", 10, 100);
        cat.info();
        cat.run(100);
        cat.run(1);
        cat.swim(1);
        cat.info();
        System.out.println("The cat finished");

        System.out.println("The dog is ready: ");
        Dog dog = new Dog("Sharik", 20, 3, 200);
        dog.info();
        dog.run(100);
        dog.swim(50);
        dog.run(100);
        dog.info();
        System.out.println("The dog finished");

        System.out.println("The horse is ready: ");
        Horse horse = new Horse("Molniya", 50, 5, 1000);
        horse.info();
        horse.swim(100);
        horse.run(500);
        horse.swim(50);
        horse.run(100);
        horse.info();
        System.out.println("The horse finished");
    }
}
