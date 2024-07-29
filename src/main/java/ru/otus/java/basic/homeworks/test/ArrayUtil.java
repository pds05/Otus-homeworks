package ru.otus.java.basic.homeworks.test;

public class ArrayUtil {
    public static int[] takeArrayAfterOne(int[] arr) {
        int[] newArr = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                int k = i + 1;
                newArr = new int[arr.length - k];
                for (int j = 0; j < newArr.length; j++, k++) {
                    newArr[j] = arr[k];
                }
                break;
            }
        }
        if (newArr == null) {
            throw new RuntimeException("отсутсвует 1 в входном массиве");
        }
        return newArr;
    }

    public static boolean checkArrayOnOneAndTwo(int[] arr) {
        boolean one = false;
        boolean two = false;
        boolean other = false;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    one = true;
                    break;
                case 2:
                    two = true;
                    break;
                default: {
                    other = true;
                    break;
                }
            }
        }
        return one && two && !other;
    }
}
