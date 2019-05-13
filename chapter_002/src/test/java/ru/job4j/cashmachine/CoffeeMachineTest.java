package ru.job4j.cashmachine;

import org.junit.Test;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void change() {
        CoffeeMachine machine = new CoffeeMachine();
        List<Integer> result = machine.change(50, 35);
        assertThat(result, is(asList(10, 5)));
    }

    @Test
    public void change2() {
        CoffeeMachine machine = new CoffeeMachine();
        List<Integer> result = machine.change(100, 31);
        assertThat(result, is(asList(10, 10, 10, 10, 10, 10, 5, 2, 2)));
    }
}