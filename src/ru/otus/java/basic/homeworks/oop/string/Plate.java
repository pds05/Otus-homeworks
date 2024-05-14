package ru.otus.java.basic.homeworks.oop.string;

public class Plate {
    private int plateSize;
    private int maxFoodSize;
    private int currentFoodSize;
    private boolean empty;

    public Plate(int plateSize) {
        this.plateSize = plateSize;
        this.maxFoodSize = plateSize;
        this.currentFoodSize = plateSize;
    }

    public int getPlateSize() {
        return plateSize;
    }

    public int getMaxFoodSize() {
        return maxFoodSize;
    }

    public int getCurrentFoodSize() {
        return currentFoodSize;
    }

    public void putFood(int size) {
        if((size + currentFoodSize) > maxFoodSize) {
            System.out.println("Еды слишком много, тарелка переполнится.");
            return;
        }
        currentFoodSize += size;
        empty = false;
        System.out.println("Тарелка наполнена едой: уровень еды=" + currentFoodSize + ", размер тарелки=" + plateSize);
    }

    public boolean takeFood(int size) {
        if (empty || currentFoodSize < size) {
            System.out.println("Не хватает еды в тарелке");
            return false;
        }
        currentFoodSize -= size;
        if(currentFoodSize == 0) empty = true;
        return true;
    }

    public void info(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Plate{" +
                "plateSize=" + plateSize +
                ", maxFoodSize=" + maxFoodSize +
                ", currentFoodSize=" + currentFoodSize +
                ", empty=" + empty +
                '}';
    }
}
