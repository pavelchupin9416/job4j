package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ConverterTest.
 *
 * @author Pavel Chupin (pavelchupin94@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConverterTest {

    /**
     * Test converter.rubleToDollar.
     */
    @Test
    public void when65RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(65);
        assertThat(result, is(1));
    }


    /**
     * Test converter.rubleToEuro.
     */
    @Test
    public void when74RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(74);
        assertThat(result, is(1));
    }

    /**
     * Test converter.dollarToRuble.
     */
    @Test
    public void when1DollarToRubleThen65() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(1);
        assertThat(result, is(65));
    }

    /**
     * Test converter.euroToRuble.
     */
    @Test
    public void when2EuroToRubleThen148() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(2);
        assertThat(result, is(148));
    }
}
