package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Класс TransformMatrixToList
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 22.10.2019
 * @version 1
 */
public class TransformMatrixToList {
    /**
     * Метод преобразует массив целых чисел в список с помощью Stream
     * @param matrix - матрица целых чисел
     * @return - список, преобразованный из матрицы целых чисел
     */
    public List<Integer> transform(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
