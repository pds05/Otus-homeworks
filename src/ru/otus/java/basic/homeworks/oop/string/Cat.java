package ru.otus.java.basic.homeworks.oop.string;

public class Cat {
    private static final int MAX_APPETITE = 10;
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public boolean eat(Plate plate) {
        if (plate == null) {
            throw new RuntimeException("Коту нужна тарелка с едой");
        }
        if (satiety) {
            System.out.println("Кот " + name + "сыт и есть не хочет");
            return false;
        }
        if (!plate.takeFood(appetite)) {
            System.out.println("Кот " + name + " не смог поесть");
            return false;
        }
        satiety = true;
        System.out.println("Кот " + name + " наелся!");
        return true;
    }

    public static int createAppetite() {
        return (int) (Math.random() * MAX_APPETITE + 1);

    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
