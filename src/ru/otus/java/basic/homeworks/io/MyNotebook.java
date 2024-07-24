package ru.otus.java.basic.homeworks.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyNotebook {
    private static final String PATH = "";

    public static void main(String[] args) {
        File[] files = readDir(PATH);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
        try(Scanner scanner = new Scanner(System.in);) {
            System.out.println("Введи имя файла:");
            String fileName = scanner.nextLine();

            File file = getFile(files, fileName);
            readFile(file);

            System.out.println("Добавь текст в файл:");
            String text = scanner.nextLine();
            if (writeFile(file, "\r\n" + text)) {
                System.out.println("Файл успешно обновлен.");
            }
        }
    }

    public static File[] readDir(String homeDir) {
        File dir = new File(Paths.get(homeDir).toAbsolutePath().toString());
        return dir.listFiles(pathname -> {
            String fileName = pathname.getName();
            if (pathname.isFile() && fileName.endsWith(".txt")) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
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
