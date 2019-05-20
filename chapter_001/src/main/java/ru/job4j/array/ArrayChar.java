package ru.job4j.array;
/**
 * Класс ArrayChar
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 11.05.2019
 * @version 1
 */
public class ArrayChar {
    private char[] array;

    public ArrayChar(String line) {
        this.array = line.toCharArray();
    }
    /**
     * Метод проверяет что слово начинается с префикса
     * @param prefix - строка (префикс)
     * @return возвращает true, если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != array[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
