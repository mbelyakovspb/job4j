package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
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
