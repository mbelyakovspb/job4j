package ru.job4j.filtration;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentLevelOfTest {
    @Test
    public void whenTheCertificateGradeIsMoreThanFour() {
        List<Student> list = List.of(
        new Student("Petr", 3),
        new Student("Jorik", 2),
        new Student("Bob", 5),
        new Student("Fill", 4),
        new Student("Fillish", 1),
        new Student(null, 0)
        );
        StudentLevelOf studentLevelOf = new StudentLevelOf();
        List<Student> result = studentLevelOf.levelOf(list, 3);
        List<Student> expected = List.of(
                new Student("Bob", 5),
                new Student("Fill", 4)
        );
        assertThat(result, is(expected));
    }
}