package ru.job4j.converter;
/**
 * Класс Конвертер валют
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.05.2019
 * @version 1
 */
public class Converter {
    /**
     * Метод конвертирует рубли в евро
     * @param value ruble
     * @return euro
     */
    public int rubleToEuro(int value) {
        return value * 70;
    }
    /**
     * Метод конвертирует рубли в доллары
     * @param value ruble
     * @return dollar
     */
    public int rubleToDollar(int value) {
        return value * 60;
    }
    /**
     * Метод конвертирует евро в рубли
     * @param value ruble
     * @return euro
     */
    public double euroToRuble(double value) {
        return Math.round((value / 70) * 1000d) / 1000d;
    }
    /**
     * Метод конвертирует доллары в рубли
     * @param value ruble
     * @return dollar
     */
    public double dollarToRuble(double value) {
        return Math.round((value / 60) * 1000d) / 1000d;
    }
}
