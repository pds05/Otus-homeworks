package ru.otus.java.basic.homeworks.oop1;


public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private int yearOfBirthday;
    private String email;

    public User(String firstName, String lastName, String middleName, int yearOfBirthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.yearOfBirthday = yearOfBirthday;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(int yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ФИО:" + lastName + " " + firstName + " " + middleName + System.lineSeparator() +
                "Год рождения: " + yearOfBirthday + System.lineSeparator() +
                "email: " + email;
    }
}