package com.example.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
