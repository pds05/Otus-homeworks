package ru.otus.java.basic.homeworks.oop1;

public class Box {
    private Integer width;
    private Integer height;
    private BoxColor color;
    private String innerObject;
    private boolean open = false;

    public Box(int width, int height, BoxColor color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BoxColor getColor() {
        return color;
    }

    public void setColor(BoxColor color) {
        this.color = color;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        System.out.println("Коробка открыта");
        this.open = true;
    }

    public void close() {
        System.out.println("Коробка закрыта");
        this.open = false;
    }

    public String extract() throws Exception {
        if (!open) {
            throw new Exception("Ошибка извлечения: коробка закрыта");
        }
        if (innerObject == null) {
            throw new Exception("Ошибка извлечения: коробка пустая");
        }
        System.out.println("Из коробки извлечен объект: " + innerObject);
        String retrievedObject = new String(innerObject);
        innerObject = null;
        System.out.println("Коробка " + (innerObject == null ? "пустая" : "полная"));
        return retrievedObject;
    }

    public void put(String object) throws Exception {
        if (!open) {
            throw new Exception("Ошибка упаковки: коробка закрыта");
        }
        if (innerObject != null) {
            throw new Exception("Ошибка упаковки: коробка заполнена");
        }
        this.innerObject = object;
        System.out.println("В коробку помещен объект: " + innerObject);
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", color=" + color +
                ", innerObject='" + innerObject + '\'' +
                ", open=" + open +
                '}';
    }

    public enum BoxColor {RED, Orange, Blue, White, Green}
}
