package ru.job4j.students;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.*;
import java.util.stream.Stream;


/**
 *Class Student хранит баллы студентов.
 *@author chupin
 *@since 4.01.2020
 */
public class Student  implements Comparable<Student> {

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


    @Override
    public int compareTo(Student st) {
        return Integer.compare(st.score, this.score);
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).takeWhile(e -> e.score > bound).collect(Collectors.toList());
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
