package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {

    private final PrintStream stdOut = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdOut);
        System.out.println("Execute after method");
    }

    @Test
    public void whenDrawSquare() {
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+++++++++" + '\n')
                                .append("+       +" + '\n')
                                .append("+       +" + '\n')
                                .append("+       +" + '\n')
                                .append("+++++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("    ^    " + '\n')
                                .append("   ^^^   " + '\n')
                                .append("  ^^^^^  " + '\n')
                                .append(" ^^^^^^^ " + '\n')
                                .append("^^^^^^^^^")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}