package ru.job4j.tracker;

public class SingleLazyOne {
    private static SingleLazyOne instance;

    private SingleLazyOne() {
    }

    public static SingleLazyOne getInstance() {
        if (instance == null) {
            instance = new SingleLazyOne();
        }
        return instance;
    }
}
