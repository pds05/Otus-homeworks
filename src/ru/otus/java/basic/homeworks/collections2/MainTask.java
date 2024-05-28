package ru.otus.java.basic.homeworks.collections2;

public class MainTask {
    public static void main(String[] args) {
        PhoneBook.add("Вася", "+79271234455");
        PhoneBook.add("Коля", "+79271235566");
        PhoneBook.add("Коля", "+79271235577");
        PhoneBook.add("Коля", "+79271235588");
        PhoneBook.add("Петя", "+79271236677");

        System.out.println(PhoneBook.find("Коля"));
        System.out.println("Номер +79271236677 в справочнике - " + PhoneBook.containsPhoneNumber("+79271236677"));
        System.out.println("Всего контактов: " + PhoneBook.getContactsCount());
    }
}
