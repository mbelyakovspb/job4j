package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    private final ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadStdOut() {
        System.setOut(new PrintStream(this.stdOut));
    }

    @After
    public void backOut() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput validateInput = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        validateInput.ask("Enter", new int[]{1});
        assertThat(this.stdOut.toString(),
                is(
                        String.format("Вы ввели значение, отличное от числа! Введите число из меню!%n")
                ));
    }
}