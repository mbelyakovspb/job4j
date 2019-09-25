package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * Класс School
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 25.09.2019
 * @version 1
 */
public class School {
    /**
     * Метод возвращает список учеников с балами, из заданных диапазонов
     * @param students - список студентов
     * @param predicate - условия фильтрации (отбора)
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}
