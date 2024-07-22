package ru.otus.java.basic.homeworks.generics;

import java.util.ArrayList;
import java.util.List;

public class GardenApp {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple(3));
        apples.add(new Apple(5));
        apples.add(new Apple(7));
        apples.add(new Apple(9));

        List<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange(2));
        oranges.add(new Orange(4));
        oranges.add(new Orange(6));
        oranges.add(new Orange(8));

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple(3));
        fruits.add(new Apple(5));
        fruits.add(new Orange(7));
        fruits.add(new Orange(9));

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.put(apples);
        System.out.println("appleBox1 весит " + appleBox1.getBoxWeight());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.put(oranges);
        System.out.println("orangeBox1 весит " + orangeBox1.getBoxWeight());

        Box<Fruit> fruitBox1 = new Box<>();
        fruitBox1.put(fruits);
        System.out.println("fruitBox1 весит " + fruitBox1.getBoxWeight());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.put(new Apple(10));
        appleBox2.move(appleBox1);
        System.out.println("appleBox2 весит " + appleBox2.getBoxWeight());
        System.out.println("масса appleBox1 равна appleBox2 -" + appleBox1.compare(appleBox2));

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.put(new Orange(10));
        orangeBox2.move(orangeBox1);
        System.out.println("orangeBox2 весит " + orangeBox2.getBoxWeight());
        System.out.println("масса orangeBox1 равна orangeBox2 -" + orangeBox1.compare(orangeBox2));

        Box<Fruit> fruitBox2 = new Box<>();
        fruitBox2.put(new Apple(10));
        fruitBox2.put(new Orange(10));
        fruitBox2.move(fruitBox1);
        System.out.println("fruitBox2 весит " + fruitBox2.getBoxWeight());
        System.out.println("масса fruitBox1 равна fruitBox2 -" + fruitBox1.compare(fruitBox2));

        System.out.println("масса appleBox1 равна orangeBox2 -" + appleBox1.compare(orangeBox2));
        System.out.println("масса appleBox1 равна fruitBox1 -" + appleBox1.compare(fruitBox1));
    }
}
