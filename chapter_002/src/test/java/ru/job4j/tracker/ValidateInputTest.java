package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * //TODO add comments.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Plese enter data again.%n")
                )
        );
    }

    @Test
    public void whenInvalidKeyInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"9", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Plese select key from menu.%n")
                )
        );
    }
}