package ru.otus.java.basic.homeworks.algoritms.company;

import java.util.*;

public class PersonDataBase {
    private static final Map<Long,Person> persons = new HashMap<>();
    private static final Set<Person.Position> managers = new HashSet<>();
    private static final EnumSet<Person.Position> positions = EnumSet.allOf(Person.Position.class);

    static {
        managers.add(Person.Position.MANAGER);
        managers.add(Person.Position.DIRECTOR);
        managers.add(Person.Position.BRANCH_DIRECTOR);
        managers.add(Person.Position.SENIOR_MANAGER);
    }

    public Person findById(Long id){
        return persons.get(id);
    }

    public void add(Person person){
        persons.put(person.getId(), person);
    }

    public boolean isManager(Person person){
        return managers.contains(person.getPosition());
    }

    public boolean isEmployee(Long id){
        Person.Position position = persons.get(id).getPosition();
        return !managers.contains(position) && positions.contains(position);
    }
}
