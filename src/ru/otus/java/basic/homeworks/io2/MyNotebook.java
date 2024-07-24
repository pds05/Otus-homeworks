package ru.otus.java.basic.homeworks.io2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyNotebook {
    private static final String PATH = "";
    private static final String CHARSET_NAME = "UTF-8";

    public static void main(String[] args) {
        File[] files = readDir(PATH);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }
        try(Scanner scanner = new Scanner(System.in);) {
            System.out.println("Введи имя файла:");
            String fileName = scanner.next();
            File file = getFile(files, fileName);

            System.out.println("Введите искомую последовательность символов с учетом регистра:");
            String pattern = scanner.next();

            search(file, pattern);
        }
    }

    public static int[] compilePatternToArray(String pattern) {
        int patternLength = pattern.length();
        int[] patternArray = new int[patternLength];
        patternArray[0] = 0;

        for(int i = 1; i < patternLength; i++ ) {
            int k = patternArray[i - 1];
            while (pattern.charAt(i) != pattern.charAt(k) && k > 0) {
                k = patternArray[k - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(k)) {
                patternArray[i] = k + 1;
            } else {
                patternArray[i] = 0;
            }
        }
        return patternArray;
    }

    public static List<Integer> perfomKMPSearch(String text, String pattern){
        int[] compiledPatternArray = compilePatternToArray(pattern);
        int textIndex = 0;
        int patternIndex = 0;
        List<Integer> foundedIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            }
            if(patternIndex == pattern.length()){
                foundedIndexes.add(textIndex - patternIndex);
                patternIndex = compiledPatternArray[patternIndex - 1];
            } else {
                if (textIndex <= text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                    if(patternIndex != 0) {
                        patternIndex = compiledPatternArray[patternIndex - 1];
                    } else {
                        textIndex = textIndex + 1;
                    }
                }
            }
        }
        return foundedIndexes;
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

    public static void search(File file, String pattern) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, Charset.forName(CHARSET_NAME)))) {
            String line;
            int i = 1;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                List<Integer> foundedIndexes = perfomKMPSearch(line, pattern);
                if (!foundedIndexes.isEmpty()) {
                    result += foundedIndexes.size();
                    System.out.println("Найдено совпадение строка=" + i + ", индексы=" + foundedIndexes);
                }
                i++;
            }
            System.out.println("Всего найдено совпадений - " + result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
