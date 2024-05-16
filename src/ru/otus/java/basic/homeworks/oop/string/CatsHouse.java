package ru.otus.java.basic.homeworks.oop.string;

public class CatsHouse {
    private static final int CATS_TOTAL = 10;

    public static void main(String[] args) {
        System.out.println("Создаем котов:");
        Cat[] cats = new Cat[CATS_TOTAL];
        for (int i = 0; i < CATS_TOTAL; i++) {
            Cat cat = new Cat("Cat" + i, Cat.createAppetite());
            cat.info();
            cats[i]=cat;
        }
        System.out.println("Готовим тарелку с едой:");
        Plate plate = new Plate(30);
        plate.info();

        System.out.println("Зовем котов есть:");
        for (int i = 0; i < cats.length; i++) {
            if(!cats[i].eat(plate)) {
                plate.info();
                System.out.println("Добавим немного корма:");
                plate.putFood(20);
                cats[i].eat(plate);
            }
        }
        System.out.println("Остатки в тарелке:");
        plate.info();

        System.out.println("Состояние котов:");
        for (int i = 0; i < cats.length ; i++) {
            Cat cat = cats[i];
            System.out.println(cat.getName() + " сытый=" + cat.isSatiety());
        }
    }
}
