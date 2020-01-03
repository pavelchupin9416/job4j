package ru.job4j.diapason;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class DiapasonsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {

        List<Double> result = Diapasons.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadroResults() {

        List<Double> result = Diapasons.diapason(5, 8, x -> 2 * Math.pow(x, 2) - 7 * x + 9);
        List<Double> expected = Arrays.asList(24D, 39D, 58D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {

        List<Double> result = Diapasons.diapason(1, 4, x -> Math.log(x) / Math.log(2));
        List<Double> expected = Arrays.asList(0D, 1D, 1.5849625007211563D);
        assertThat(result, is(expected));
    }
}
