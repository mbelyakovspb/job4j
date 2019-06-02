package ru.job4j.condition;
/**
 * Класс DummyBot
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 03.05.2019
 * @version 1
 */
public class DummyBot {
    /**
     * Метод возвращает ответ бота на фразу
     * @param question фраза адресованная боту
     * @return ответ бота на на переданную фразу
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, бот".equals(question)) {
            rsl = "Привет умник.";
        } else if ("Пока".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
