package ru.job4j.students;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *Class School фильтрация студентов.
 *@author chupin
 *@since 4.01.2020
 */
public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return   students.stream().filter(stud -> predict.test(stud)).collect(Collectors.toList());
    }
}
