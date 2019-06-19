package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.parseInt(ask(question));
        boolean result = false;
        for (int value : range) {
            if (value == key) {
                result = true;
                break;
            }
        }
        if (!result) {
            throw new MenuOutException("Вы ввели цифру, которой нет в меню");
        }
        return key;
    }
}
