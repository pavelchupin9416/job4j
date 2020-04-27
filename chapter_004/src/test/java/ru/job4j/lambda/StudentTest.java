package ru.job4j.lambda;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;


public class StudentTest {
    @Test
    public void whenStudetnGroupedUnit() {
        List<Student> students = List.of(new Student("Иван", Set.of("Футбол", "Волейбол")),
                new Student("Петр", Set.of("Волейбол", "Плаванье")));
         Group group = new Group();
        Map<String, Set<String>> sect = Group.sections(students);
        Map<String, Set<String>> test = new HashMap<>();
        test.put("Плаванье", Set.of("Петр"));
        test.put("Футбол", Set.of("Иван"));
        test.put("Волейбол", Set.of("Иван", "Петр"));
       assertThat(sect, is(test));
    }


    @Test
    public void whenStudetnGroupedUnits() {
        List<Student> students = List.of(new Student("Николай", Set.of("Футбол", "Волейбол")),
                new Student("Виктор", Set.of("Волейбол", "Плаванье")),
                new Student("Михаил", Set.of("Плаванье", "Футбол")));
        Group group = new Group();
        Map<String, Set<String>> sect = Group.sections(students);
        Map<String, Set<String>> test = new HashMap<>();
        test.put("Плаванье", Set.of("Виктор", "Михаил"));
        test.put("Футбол", Set.of("Николай", "Михаил"));
        test.put("Волейбол", Set.of("Николай", "Виктор"));
        assertThat(sect, is(test));
    }
}
