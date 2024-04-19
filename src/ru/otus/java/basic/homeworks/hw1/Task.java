package ru.otus.java.basic.homeworks.hw1;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        while(!stop) {
            System.out.println("Введите число от 1 до 5:");
            int num = scanner.nextInt();
            switch (num) {
                case 1: {
                    greetings();
                } break;
                case 2: {
                    checkSign (randomInt(10, false), randomInt(10, false), randomInt(10, true));
                } break;
                case 3: {
                    selectColor();
                } break;
                case 4: {
                    compareNumbers();
                } break;
                case 5: {
                    addOrSubtractAndPrint(randomInt(10, true), randomInt(10, true), Math.random() < 0.5);
                } break;
                default: {
                    System.out.println("Вы ввели неправильное значение.");
                }
            }
            System.out.println("Нажми Y для повтора");
            stop = !scanner.hasNext("[yY]+");
            scanner.next();
        }
        scanner.close();
    }

    public static void greetings() {
        System.out.printf("Hellow%nWorld%nfrom%nJava%n");
    }

    public static void checkSign(int a, int b, int c) {
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor(){
        int data = randomInt(30, true);
        System.out.println("data = " + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = randomInt(100, false);
        System.out.println("a = " + a);
        int b = randomInt(100, false);
        System.out.println("b = " + b);
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment){
        System.out.println("initValue = " + initValue + ", delta = " + delta + ", increment = " + increment);
        if (increment) {
            System.out.println(initValue += delta);
        } else {
            System.out.println(initValue -= delta);
        }
    }

    public static int randomInt(int maxValue, boolean onlyPositive) {
        return (int) (Math.random() * maxValue + 1) * (onlyPositive ? 1 : Math.random() < 0.5 ? 1 : -1 );
    }
}
