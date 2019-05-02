package ru.job4j.calculate;
/**
 * Класс Калькулятор
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.05.2019
 * @version 1
 */
public class Calculator {
    /**
     * Метод складывает два числа
     * @param first, second
     * @return сумму чисел first, second
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     * Метод вычитает из второго числа первое
     * @param first, second
     * @return разность чисел first, second
     */
    public double sub(double first, double second) {
        return second - first;
    }
    /**
     * Метод умножает первое число на второе
     * @param first, second
     * @return произведение чисел first, second
     */
    public double multipl(double first, double second) {
        return first * second;
    }
    /**
     * Метод делит первое число на второе
     * @param first, second
     * @return результат деления числа first на second
     */
    public double div(double first, double second) {
        return first / second;
    }

}
