package ru.otus.java.basic.homeworks.collections2;

import java.util.*;

public class PhoneBook {
    private static Map<String, List<String>> contacts;

    static {
        contacts = new HashMap<>();
    }

    public PhoneBook() {
    }

    public static void add(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            contacts.put(name, numbers);
        }
    }

    public static List<String> find(String name) {
        List<String> result = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> entrySet = contacts.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            if (name.equals(entry.getKey())) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    public static boolean containsPhoneNumber(String phoneNumber) {
        for (List<String> entry : contacts.values()) {
            if (entry.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public static int getContactsCount() {
        return contacts.size();
    }
}
