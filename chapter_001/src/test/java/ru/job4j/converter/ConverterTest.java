package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void when1EuroEqual70Rubles() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(1);
        double expected = 70D;
        assertThat(result, is(expected));
    }

    @Test
    public void when1DollarEqual60Rubles() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(1);
        double expected = 60D;
        assertThat(result, is(expected));
    }

    @Test
    public void when1RubleEqual0_014Euro() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(1);
        double expected = 0.014D;
        assertThat(result, is(expected));
    }

    @Test
    public void when1RubleEqual0_017Dollar() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(1);
        double expected = 0.017D;
        assertThat(result, is(expected));
    }
}