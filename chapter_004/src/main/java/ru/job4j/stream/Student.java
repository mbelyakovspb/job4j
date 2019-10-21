package ru.job4j.stream;
/**
 * Класс Student
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 25.09.2019
 * @version 1
 */
public class Student {
    private final int score;
    private final String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + '}';
    }
}
