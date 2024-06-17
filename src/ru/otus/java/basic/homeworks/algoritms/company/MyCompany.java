package ru.otus.java.basic.homeworks.algoritms.company;

public class MyCompany {
    public static void main(String[] args) {
        PersonDataBase db = new PersonDataBase();

        Person person0 = new Person("Коля", Person.Position.DIRECTOR, 100L);
        db.add(person0);

        Person person1 = new Person("Вася", Person.Position.MANAGER, 101L);
        db.add(person1);

        Person person2 = new Person("Маша", Person.Position.SENIOR_MANAGER, 102L);
        db.add(person2);

        Person person3 = new Person("Витя", Person.Position.DRIVER, 103L);
        db.add(person3);

        Person person4 = new Person("Саша", Person.Position.PLUMBER, 104L);
        db.add(person4);

        Person person5 = new Person("Миша", Person.Position.QA, 105L);
        db.add(person5);

        Person person6 = new Person("Костя", Person.Position.JUNIOR_DEVELOPER, 106L);
        db.add(person6);

        Person person7 = new Person("Матвей", Person.Position.JANITOR, 107L);
        db.add(person7);

        Person person8 = new Person("Лёня", Person.Position.DEVELOPER, 108L);
        db.add(person8);

        Person person9 = new Person("Дима", Person.Position.ENGINEER, 109L);
        db.add(person9);

        Person person10 = new Person("Серёжа", Person.Position.BRANCH_DIRECTOR, 110L);
        db.add(person10);

        System.out.println("105=" + db.findById(105L));
        System.out.println(person1 + " is manager = " + db.isManager(person1));
        System.out.println(person9 + " is manager = " + db.isManager(person9));
        System.out.println(person4 + " is employee = " + db.isEmployee(person4.getId()));
        System.out.println(person10 + " is employee = " + db.isEmployee(person10.getId()));
    }
}
