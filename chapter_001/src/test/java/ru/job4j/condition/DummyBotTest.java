package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DummyBotTest {

    @Test
    public void whenBotAnswerHiSmart() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Привет, бот"), is("Привет умник."));
    }
    @Test
    public void whenBotAnswerSeeYouSoon() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Пока"), is("До скорой встречи."));
    }
}