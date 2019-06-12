package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void sort() {
        SortUser set = new SortUser();
        List<User> list = Arrays.asList(
                new User(2, "Николай", 23),
                new User(1, "Вася", 11),
                new User(3, "Виктор", 7)
        );
        Set<User> result = set.sort(list);
        TreeSet<User> example = new TreeSet<>();
        example.add(new User(3, "Виктор", 7));
        example.add(new User(1, "Вася", 11));
        example.add(new User(2, "Николай", 23));
        assertThat(result.equals(example), is(true));
    }
}
