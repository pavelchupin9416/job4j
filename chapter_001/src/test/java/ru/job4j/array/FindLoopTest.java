package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FindLoopTest.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas4Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 6, 4, 3, 1, 7, 9};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas8Then1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 6, 4, 3, 1, 7, 9};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}