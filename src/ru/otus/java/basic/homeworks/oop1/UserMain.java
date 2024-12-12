package ru.otus.java.basic.homeworks.oop1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMain {
    public static final int USERS_TOTAL = 10;
    public static final int USERS_MAX_AGE = 40;

    public static void main(String[] args) {
        User[] users = new User[USERS_TOTAL];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User(
                    "Имя" + i,
                    "Фамилия" + i,
                    "Отчество" + i,
                    (int) (Math.random() * (2004 - 1980)) + 1980,
                    "emailOfUser" + i + "@domain.local");
        }
        int countOfPassUsers = 0;
        System.out.println("Пользователи старше " + USERS_MAX_AGE + " лет:");
        for (int i = 0; i < users.length; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            int age = Integer.parseInt(sdf.format(new Date())) - users[i].getYearOfBirthday();
            if (age >= USERS_MAX_AGE) {
                System.out.println(users[i].toString());
                System.out.println("Возраст: " + age);
            } else {
                countOfPassUsers++;
            }
        }
        System.out.println("Пользователей младше " + USERS_MAX_AGE + " лет: " + countOfPassUsers);
    }
}
