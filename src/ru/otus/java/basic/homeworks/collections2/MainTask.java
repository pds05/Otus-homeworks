package ru.otus.java.basic.homeworks.collections2;

public class MainTask {
    public static void main(String[] args) {
        PhoneBook.add("Вася", 79271234455L);
        PhoneBook.add("Коля", 79271235566L);
        PhoneBook.add("Коля", 79271235577L);
        PhoneBook.add("Коля", 79271235588L);
        PhoneBook.add("Петя", 79271236677L);

        System.out.println(PhoneBook.find("Коля"));
        System.out.println("Всего контактов: " + PhoneBook.getContactsCount());
    }

}
