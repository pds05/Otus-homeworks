package ru.otus.java.basic.homeworks.hw3;

public class Task {
    public static void main(String[] args) {
        System.out.println(sumOfPositiveElements(new int[][]{{1, 2, 3}, {4, -1, 5}, {-2, 0, 5}, {-3, 9, 1}}));
        printSquare(5);
        printMatrix(changeDiagonalEntitiesToZero(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, DiagonalType.BOTH));
        System.out.println(findMax(new int[][]{{1, 2, 3}, {4, -1, 5}, {-2, 0, 5}, {-3, 9, 1}}));
        System.out.println(sumOfSecondLineEntities(new int[][]{{1, 2, 3}, {4, -1, 5}, {-2, 0, 5}, {-3, 9, 1}}));
    }

    public static int sumOfPositiveElements(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    result += arr[i][j];
                }
            }
        }
        return result;
    }

    public static void printSquare(int size) {
        char[][] arr = new char[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static int[][] changeDiagonalEntitiesToZero(int[][] arr, DiagonalType diagonalType) {
        switch (diagonalType) {
            case LEFT -> {
                int j = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (j < arr[i].length) {
                        arr[i][j++] = 0;
                    }
                }

            }
            case RIGHT -> {
                int j = 0;
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (j < arr[i].length) {
                        arr[i][j++] = 0;
                    }
                }
            }
            case BOTH -> {
                int j = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (j < arr[i].length) {
                        arr[i][j++] = 0;
                    }
                }
                j = 0;
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (j < arr[i].length) {
                        arr[i][j++] = 0;
                    }
                }
            }
        }
        return arr;
    }

    public static int findMax(int[][] array) {
        int maxNum = array[1][1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxNum) {
                    maxNum = array[i][j];
                }
            }

        }
        return maxNum;
    }

    public enum DiagonalType {
        LEFT, RIGHT, BOTH
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int sumOfSecondLineEntities(int[][] arr) {
        int sum = 0;
        if (arr.length < 2 || arr[1].length == 0) {
            return -1;
        } else {
            for (int i = 0; i < arr[1].length; i++) {
                sum += arr[1][i];
            }
        }
        return sum;
    }
}
