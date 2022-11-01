package com.example;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public class Artist extends Person {
        private String specialty;

        Artist(String name, int age, String specialty) {
            super(name, age);
            this.specialty = specialty;
        }
        Artist(String name, int age) {
            super(name, age);
        }
    }
}




