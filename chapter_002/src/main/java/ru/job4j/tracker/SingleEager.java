package ru.job4j.tracker;

public class SingleEager {
    private static final SingleEager INSTANCE = new SingleEager();

    private SingleEager() {
    }

    public static SingleEager getInstance() {
        return INSTANCE;
    }
}
