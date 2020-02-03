package ru.job4j.generic;
/**
 * Класс Base
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.02.2020
 * @version 1
 */
public abstract class Base {
    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
