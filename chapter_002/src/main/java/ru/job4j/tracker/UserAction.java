package ru.job4j.tracker;

public interface UserAction {

    int key();

    void exucute(Input input, Tracker tracker);

    String info();
}
