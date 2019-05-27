package ru.job4j.list;

public class User {

    private int id;
    private String name;
    private String city;


    public User(int id, String name, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
