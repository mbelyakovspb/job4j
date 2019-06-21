package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean result = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                result = false;
            } catch (MenuOutException obj) {
                System.out.println("Пожалуйста введите цифровое значение, соответствующее цифре из меню!");
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели значение, отличное от числа! Введите число из меню!");
            }
        } while (result);
        return value;
    }
}
