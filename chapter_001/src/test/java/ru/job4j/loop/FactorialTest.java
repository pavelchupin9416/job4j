package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTest.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {

    /**
     * Test calc.
     * факториал для числа 5 равен 120.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }

    /**
     * Test calc.
     * факториал для числа 0 равен 1.
     */

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}