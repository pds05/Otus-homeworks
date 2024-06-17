package ru.otus.java.basic.homeworks.algoritms;

import java.util.Arrays;

public class SortedClass {
    private static final int MAX_ELEMENTS = 10000;
    private static final int MAX_VALUE = MAX_ELEMENTS + MAX_ELEMENTS / 4;
    private static int[] array;

    public static void main(String[] args) {
        array = createArr(MAX_ELEMENTS);
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("Bubble sorting execution time=" + (endTime - startTime) + " msec");

        array = createArr(MAX_ELEMENTS);
        startTime = System.currentTimeMillis();
        quickSort(array);
        endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("Quick sorting execution time=" + (endTime - startTime) + " msec");
    }

    public static int[] createArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = createValue(arr, i);
        }
        return arr;
    }

    public static int createValue(int[] arr, int leftPtr) {
        int value = (int) (Math.random() * (MAX_VALUE - 1));
        for (int i = 0; i < leftPtr; i++) {
            if (arr[i] == value) {
                value = createValue(arr, leftPtr);
            }
        }
        return value;
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private static void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

    public static void quickSort(int[] array) {
        recQuickSort(0, array.length - 1);
    }

    public static void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = array[right];

            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public static int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (array[++leftPtr] < pivot) {

            }
            while (rightPtr > 0 && array[--rightPtr] > pivot) {

            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }
}
