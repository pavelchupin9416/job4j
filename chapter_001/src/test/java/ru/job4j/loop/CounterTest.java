package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class CounterTest {

    /**
     * Test add.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}