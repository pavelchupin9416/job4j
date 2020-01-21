package ru.job4j.students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *Class Student хранит баллы студентов.
 *@author chupin
 *@since 4.01.2020
 */
public class Student {

    private String name;
    private String surname;
    private int score;

    public  Student() {

    }

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, String surname, int score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
    }


    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    Map<String, Student> collect(List<Student> students) {
        return   students.stream().distinct().collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }
}
