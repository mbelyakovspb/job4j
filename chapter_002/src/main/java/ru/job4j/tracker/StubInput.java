package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
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
