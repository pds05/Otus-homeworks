package ru.otus.java.basic.homeworks.exc;

public class MainTask {

    public static void main(String[] args) {
        String[][] arr = createArray(4, 4, false);
        int sum = sumItemsOfArray(arr);
        System.out.println("Сумма элементов массива=" + sum);
    }

    public static String[][] createArray(int lines, int columns, boolean makeMistake) {
        String[][] arr = new String[lines][columns];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (makeMistake && i == 2 && j == 2) {
                    arr[i][j] = "error";
                } else {
                    arr[i][j] = String.valueOf(i + j);
                }
            }
        }
        return arr;
    }

    public static void ckeckArray(String[][] arr) {
        if (arr == null || arr.length != 4 || arr[0].length != 4) {
            throw new AppArraySizeException("Mismatch sizing array");
        }
    }

    public static int sumItemsOfArray(String[][] arr) {
        ckeckArray(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int value = Integer.valueOf(arr[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j, "element not int");
                }
            }
        }
        return sum;

    }

    static class AppArraySizeException extends RuntimeException {
        public AppArraySizeException(String msg) {
            super(msg);
        }

        @Override
        public String toString() {
            return "AppArraySizeException{" + super.toString() + "}";
        }
    }

    static class AppArrayDataException extends RuntimeException {
        private int line;
        private int column;

        public AppArrayDataException(int line, int column, String msg) {
            super(msg);
            this.line = line;
            this.column = column;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("AppArrayDataException{invalid element:line=");
            sb.append(line);
            sb.append("; column=");
            sb.append(column);
            sb.append("; message=");
            sb.append(super.toString());
            sb.append('}');
            return sb.toString();
        }
    }
}
