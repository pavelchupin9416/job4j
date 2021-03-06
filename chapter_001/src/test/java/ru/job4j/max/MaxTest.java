package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondAndThirdLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(4, 2, 1);
        assertThat(result, is(4));
    }
}
