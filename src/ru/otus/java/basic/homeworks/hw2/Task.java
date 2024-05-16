package ru.otus.java.basic.homeworks.hw2;

import java.util.Arrays;

public class Task {

    public static void main(String[] args) {
        printRepeatString(3, "Hello World!");

        printSumArrayItems(new int[]{2, 5, 6, 9});

        System.out.println(Arrays.toString(fillArray(5, new int[5])));

        System.out.println(Arrays.toString(sumItemsArrayWithItem(5, new int[]{1, 2, 3, 4, 5})));

        compareAndSumHalfItemsArray(new int[]{10, 4, 7});
    }

    public static void printRepeatString(int repeat, String message) {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    public static void printSumArrayItems(int[] arr) {
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 5) {
                    sum += arr[i];
                }
            }
        }
        System.out.println("sum = " + sum);
    }

    public static int[] fillArray(int item, int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = item;
            }
        }
        return arr;
    }

    public static int[] sumItemsArrayWithItem(int item, int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += item;
            }
        }
        return arr;
    }

    public static void compareAndSumHalfItemsArray(int[] arr) {
        if (arr != null) {
            int sum1 = 0;
            int sum2 = 0;
            int i = 0;
            for (; i < arr.length / 2; i++) {
                sum1 += arr[i];
            }
            //для нечетного массива промежуточный элемент попадает в правую половину
            for (; i < arr.length; i++) {
                sum2 += arr[i];
            }
            if (sum1 > sum2) {
                System.out.println("Сумма первой половины массива больше = " + sum1);
            } else if (sum1 < sum2) {
                System.out.println("Сумма второй половины массива больше = " + sum2);
            } else {
                System.out.println("Суммы половин массива совпадают = " + sum1);
            }
        }
    }
}
