package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentToMapTest {

    @Test
    public void whenListTransformationToMap() {
        Student student1 = new Student(80, "10А");
        Student student2 = new Student(60, "10Б");
        Student student3 = new Student(30, "10В");
        List<Student> students = List.of(
                student1, student2, student3
        );
        Map<String, Student> result = new StudentToMap().transformation(students);
        Map<String, Student> expected = new TreeMap<>();
        expected.put("10А", student1);
        expected.put("10Б", student2);
        expected.put("10В", student3);
        assertThat(result, is(expected));
    }
}