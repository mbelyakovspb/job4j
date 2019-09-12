package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * Класс FunctionRange
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 12.09.2019
 * @version 1
 */
public class FunctionRange {
    /**
     * Метод умножает два значения
     * @param start - первое число int
     * @param end - второе число int
     * @param function - функциональный интерфейс, возвращает значение типа Double
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(function.apply((double) index));
        }
        return result;
    }
}
