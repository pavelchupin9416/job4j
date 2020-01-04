package ru.job4j.students;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;


import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenStudent80and100() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(99));
        students.add(new Student(65));
        students.add(new Student(84));
        List<Student> result = new School().collect(students, student -> student.getScore() > 70 && student.getScore() <= 100);
        students.remove(students.get(1));
        assertThat(result, is(students));
    }

    @Test
    public void whenStudent50and70() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(56));
        students.add(new Student(34));
        students.add(new Student(69));
        List<Student> result = new School().collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        students.remove(students.get(1));
        assertThat(result, is(students));
    }

    @Test
    public void whenStudent0and50() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(25));
        students.add(new Student(65));
        students.add(new Student(11));
        List<Student> result = new School().collect(students, student -> student.getScore() > 0 && student.getScore() <= 50);
        students.remove(students.get(1));
        assertThat(result, is(students));
    }
}
