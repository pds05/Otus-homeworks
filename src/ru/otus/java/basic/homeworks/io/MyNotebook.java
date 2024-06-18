package ru.otus.java.basic.homeworks.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyNotebook {
    private static final String PATH = ".\\";

    public static void main(String[] args) {
        File[] files = readDir(PATH);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи имя файла:");
        String fileName = scanner.nextLine();

        File file = getFile(files, fileName);
        readFile(file);

        System.out.println("Добавь текст в файл:");
        String text = scanner.nextLine();
        if (writeFile(file, "\r\n" + text)) {
            System.out.println("Файл успешно обновлен.");
        }
        scanner.close();
    }

    public static File[] readDir(String path) {
        File dir = new File(path);
        return dir.listFiles(pathname -> {
            String fileName = pathname.getName();
            if (pathname.isFile() && fileName.substring(fileName.length() - 4, fileName.length()).equals(".txt")) {
                return true;
            }
            return false;
        });
    }

    public static File getFile(File[] files, String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public static void readFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            int n = reader.read();
            while (n != -1) {
                System.out.print((char) n);
                n = reader.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean writeFile(File file, String text) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
