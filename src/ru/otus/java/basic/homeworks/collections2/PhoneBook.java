package ru.otus.java.basic.homeworks.collections2;

import java.util.*;

public class PhoneBook {
    private static Map<String, List<Long>> contacts;

    static {
        contacts = new HashMap<>();
    }

    public PhoneBook(){}

    public static void add(String name, long phoneNumber){
        if(contacts.containsKey(name)){
            contacts.get(name).add(phoneNumber);
        } else {
            List<Long> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            contacts.put(name, numbers);
        }
    }

    public static List<Long> find(String name){
        List<Long> result = new ArrayList<>();
        Set<Map.Entry<String, List<Long>>> entrySet = contacts.entrySet();
        for(Map.Entry<String, List<Long>> entry : entrySet){
            if(name.equals(entry.getKey())){
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    public static int getContactsCount(){
        return contacts.size();
    }
}
