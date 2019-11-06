package ru.job4j.filtration;

import java.util.Objects;
/**
 * Класс Student
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 07.11.2019
 * @version 1
 */
public class Student {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name
                + '\'' + ", scope=" + scope
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }
}
