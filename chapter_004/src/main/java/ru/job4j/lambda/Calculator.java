package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
/**
 * Класс Calculator
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 31.08.2019
 * @version 1
 */
public class Calculator {
    /**
     * Метод умножает два значения
     * @param start - первое число int
     * @param value - второе число int
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> operation,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(operation.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.multiple(
                0, 10, 2,
                (left, right) -> {
                    double result = left * right;
                    System.out.printf("Multiple %s * %s = %s %n", left, right, result);
                    return result;
                },
                System.out::println
        );
    }
}