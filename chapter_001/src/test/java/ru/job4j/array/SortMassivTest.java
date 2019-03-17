package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortMassivTest {

    @Test
    public void whenSortTwoArraysThenSortedArray() {
        int[] first = new int[] {1, 8, 10, 22, 32, 67};
        int[] second = new int[] {2, 6, 9, 17, 27, 56};
        SortMassiv sort = new SortMassiv();
        int[] rst = sort.sortmas(first, second);
        int[] expect = new int[] {1, 2, 6, 8, 9, 10, 17, 22, 27, 32, 56, 67 };
        assertThat(rst, is(expect));
    }
}
