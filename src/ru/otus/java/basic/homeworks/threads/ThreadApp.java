package ru.otus.java.basic.homeworks.threads;

public class ThreadApp {
    private static final int ITEMS = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        double[] arr = create(ITEMS);
        long endTime = System.currentTimeMillis();
        System.out.println("One thread: time=" + (endTime - startTime) + "; size=" + arr.length);

        startTime = System.currentTimeMillis();
        MultiSumOfArray one = new MultiSumOfArray(ITEMS, 1);
        MultiSumOfArray two = new MultiSumOfArray(ITEMS, 2);
        MultiSumOfArray three = new MultiSumOfArray(ITEMS, 3);
        MultiSumOfArray four = new MultiSumOfArray(ITEMS, 4);
        one.getThread().join();
        two.getThread().join();
        three.getThread().join();
        four.getThread().join();
        endTime = System.currentTimeMillis();
        System.out.println("Multi thread: time=" + (endTime - startTime) + "; size=" + MultiSumOfArray.getArray().length);
    }

    public static double[] create(int items) {
        double[] array = new double[items];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return array;
    }
}

class MultiSumOfArray implements Runnable {
    private static double[] array = new double[0];
    private int partOfArray;
    private Thread t;

    public MultiSumOfArray(int items, int partOfArray) {
        synchronized (array) {
            if (array.length == 0) {
                array = new double[items];
            }
        }
        this.partOfArray = partOfArray;
        t = new Thread(this, String.valueOf(partOfArray));
        System.out.println("Создан поток " + t.getName());
        t.start();
    }

    public Thread getThread() {
        return t;
    }

    public static double[] getArray(){
        return array;
    }

    @Override
    public void run() {
        int partSize = array.length / 4;
        int rightMargin = partOfArray * partSize;
        int leftMargin = rightMargin - partSize;
        for (int i = leftMargin; i < rightMargin; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println("Завершен поток " + t.getName());
    }
}


