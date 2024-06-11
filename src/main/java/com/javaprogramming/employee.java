package com.javaprogramming;

public class employee {
    String name;
    int age;
    int id;
    int salary;
    public employee(){}

    public employee(int age, String name, int id, int salary) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
