package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenTheScoreIs80() {
        Student student1 = new Student(80, "10А");
        Student student2 = new Student(60, "10Б");
        Student student3 = new Student(30, "10В");
        List<Student> students = List.of(
               student1, student2, student3
        );
        Predicate<Student> predicate = student -> student.getScore() < 100
                && student.getScore() > 70;
        List<Student> result = new School().collect(students, predicate);
        List<Student> expected = List.of(student1);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheScoreIs60() {
        Student student1 = new Student(80, "10А");
        Student student2 = new Student(60, "10Б");
        Student student3 = new Student(30, "10В");
        List<Student> students = List.of(
                student1, student2, student3
        );
        Predicate<Student> predicate = student -> student.getScore() < 70
                && student.getScore() > 50;
        List<Student> result = new School().collect(students, predicate);
        List<Student> expected = List.of(student2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTheScoreIs30() {
        Student student1 = new Student(80, "10А");
        Student student2 = new Student(60, "10Б");
        Student student3 = new Student(30, "10В");
        List<Student> students = List.of(
                student1, student2, student3
        );
        Predicate<Student> predicate = student -> student.getScore() < 50
                && student.getScore() > 0;
        List<Student> result = new School().collect(students, predicate);
        List<Student> expected = List.of(student3);
        assertThat(result, is(expected));
    }
}