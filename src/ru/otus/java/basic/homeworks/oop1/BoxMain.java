package ru.otus.java.basic.homeworks.oop1;

public class BoxMain {

    public static void main(String[] args) {
        Box box = new Box(10,30, Box.BoxColor.Green);
        System.out.println("Создана коробка: " + box);
        box.setColor(Box.BoxColor.RED);
        System.out.println("Коробку перекрасили: " + box);
        String innerObject = "яблоко";
        try{
            box.put(innerObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        box.open();
        try {
            box.extract();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            box.put(innerObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        box.close();
        System.out.println("Состояние коробки: " + box);
        try {
            box.extract();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        box.open();
        try {
            String obj = box.extract();
            System.out.println("Получен объект:" + obj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        box.close();
        System.out.println("Состояние коробки: " + box);
    }
}
