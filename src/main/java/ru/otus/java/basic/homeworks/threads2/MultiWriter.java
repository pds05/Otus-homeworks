package ru.otus.java.basic.homeworks.threads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiWriter {
    public static final int REPEATS = 5;
    static String str = "";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Object monitor = new Object();

        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < REPEATS; i++) {
                    synchronized (monitor) {
                        System.out.println(Thread.currentThread().getName() + ": проверка начала строки или символа 'C'");
                        while (!str.endsWith("C") && !str.isEmpty()){
                            try{
                                System.out.println(Thread.currentThread().getName() + ": ожидание");
                                monitor.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        str = str.concat("A");
                        System.out.println(str);
                        monitor.notifyAll();
                        try{
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": закончил работу");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < REPEATS; i++) {
                    synchronized (monitor) {
                        System.out.println(Thread.currentThread().getName() + ": проверка начала строки или символа 'A'");
                        while (!str.endsWith("A")){
                            try{
                                System.out.println(Thread.currentThread().getName() + ": ожидание");
                                monitor.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        str = str.concat("B");
                        System.out.println(str);
                        monitor.notifyAll();
                        try{
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": закончил работу");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < REPEATS; i++) {
                    synchronized (monitor) {
                        System.out.println(Thread.currentThread().getName() + ": проверка начала строки или символа 'B'");
                        while (!str.endsWith("B")){
                            try{
                                System.out.println(Thread.currentThread().getName() + ": ожидание");
                                monitor.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        str = str.concat("C");
                        System.out.println(str);
                        monitor.notifyAll();
                        try{
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": закончил работу");
            }
        });

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Длина строки=" + str.length());
    }
}
