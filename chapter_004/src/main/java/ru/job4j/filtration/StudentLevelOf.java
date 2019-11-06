package ru.job4j.filtration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Класс StudentLevelOf
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 07.11.2019
 * @version 1
 */
public class StudentLevelOf {
    /**
     * Метод возвращает список учеников с баллами, выше заданного числом bound
     * @param students - список студентов
     * @param bound - условия фильтрации (балл)
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getScope).reversed())
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() > bound)
                .collect(Collectors.toList());
    }
}
