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
        List<User> list = List.of(
                new User(2, "Николай", 23),
                new User(1, "Вася", 11),
                new User(3, "Виктор", 7)
        );
        Set<User> result = set.sort(list);
        Set<User> example  = Set.of(
                new User(3, "Виктор", 7),
                new User(1, "Вася", 11),
                new User(2, "Николай", 23)
        );
        assertThat(result.equals(example), is(true));
    }

    @Test
    public void sortComparator() {
        SortUser lists = new SortUser();
        List<User> list = Arrays.asList(
                new User(2, "Николай", 23),
                new User(1, "Вася", 11),
                new User(3, "Виктор", 7)
        );
        list = lists.sortNameLength(list);
        List<User> example = List.of(
                new User(1, "Вася", 11),
                new User(3, "Виктор", 7),
                new User(2, "Николай", 23));

        assertThat(list.get(0).getName(), is(example.get(0).getName()));
    }



    @Test
    public void sortUserComparator() {
        SortUser lists = new SortUser();
        List<User> list = Arrays.asList(
                new User(1, "Сергей", 25),
                new User(2, "Иван", 30),
                new User(3, "Сергей", 20),
                new User(4, "Иван", 25)
        );
        list = lists.sortByAllFields(list);
        List<User> example = List.of(
                new User(4, "Иван", 25),
                new User(2, "Иван", 30),
                new User(3, "Сергей", 20),
                new User(1, "Сергей", 25));

        assertThat(list.get(0).getName(), is(example.get(0).getName()));
    }
}
