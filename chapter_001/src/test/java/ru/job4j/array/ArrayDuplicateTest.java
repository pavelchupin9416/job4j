package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest .
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] arr = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        ArrayDuplicate dupl = new ArrayDuplicate();

        arr = dupl.remove(arr);
        String[] expect = new String[] {"Привет", "Мир", "Супер"};
        assertThat(arr, is(expect));

    }
}