package ru.job4j.sort;

import java.util.Objects;
import java.util.*;

public class User implements Comparable<User> {

    private int id;
    private String name;
    private int age;


    public User(int id, String name, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
     return Integer.compare(this.age, o.age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
