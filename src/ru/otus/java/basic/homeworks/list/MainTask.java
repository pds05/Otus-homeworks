package ru.otus.java.basic.homeworks.list;

import java.util.ArrayList;
import java.util.List;

public class MainTask {
    public static void main(String[] args) {
        List<Integer> list = createList(-10, 10);
        System.out.println(list);
        System.out.println("sum=" + sumArrayItemsMoreThanFive(list));
        replaceListItems(0, list);
        System.out.println(list);
        increaseListItems(5, list);
        System.out.println(list);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Вася", 25));
        employees.add(new Employee("Коля", 20));
        employees.add(new Employee("Петя", 30));

        System.out.println("Список сотрудников: " + getEmployeeNames(employees));
        int minAge = 25;
        System.out.println("Сотрудники старше " + minAge + " лет: " + getEmployeesOlderThanAge(employees, minAge));
        int minAverageAge = 24;
        System.out.println("Средний возраст отдела больше " + minAverageAge + " - " + checkEmployeesAverageAge(employees, minAverageAge));
        System.out.println("Самый молодой сотрудник: " + takeYoungestEmployee(employees));
    }

    public static List<Integer> createList(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException("max argument must greater than min");
        }
        List<Integer> list = new ArrayList<>(max - min + 1);
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int sumArrayItemsMoreThanFive(List<Integer> list) {
        checkList(list);
        int sum = 0;
        for (int i : list) {
            if (i > 5) {
                sum += i;
            }
        }
        return sum;
    }

    public static void replaceListItems(int number, List<Integer> list) {
        checkList(list);
        list.replaceAll(item -> {
            return number;
        });
    }

    public static void increaseListItems(int number, List<Integer> list) {
        checkList(list);
        list.replaceAll(item -> {
            return item + number;
        });
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        checkList(employees);
        List<String> names = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    public static List<Employee> getEmployeesOlderThanAge(List<Employee> employees, int minAge) {
        checkList(employees);
        List<Employee> oldEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                oldEmployees.add(employee);
            }
        }
        return oldEmployees;
    }

    public static boolean checkEmployeesAverageAge(List<Employee> employees, int minAverageAge) {
        checkList(employees);
        int sumAge = 0;
        for (Employee employee : employees) {
            sumAge += employee.getAge();
        }
        return sumAge / employees.size() > minAverageAge;
    }

    public static Employee takeYoungestEmployee(List<Employee> employees){
        checkList(employees);
        Employee youngest = null;
        if(!employees.isEmpty()) {
            youngest = employees.get(0);
        }
        for (int i=1; i<employees.size(); i++){
            Employee item = employees.get(i);
            if(item.getAge()<youngest.getAge()){
                youngest = item;
            }
        }
        return youngest;
    }

    private static void checkList(List list) {
        if (list == null) {
            throw new IllegalArgumentException("list must not be null");
        }
    }
}
