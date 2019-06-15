package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private final Tracker tracker = new Tracker();

    private final PrintStream stdOut = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Item item = this.tracker.add(new Item("test name", "desc"));

    private final StringBuilder menu = new StringBuilder()
            .append("Меню")
            .append(System.lineSeparator())
            .append("0. Добавить новую заявку")
            .append(System.lineSeparator())
            .append("1. Показать все заявки")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку")
            .append(System.lineSeparator())
            .append("3. Удалить заявку")
            .append(System.lineSeparator())
            .append("4. Найти заявку по id")
            .append(System.lineSeparator())
            .append("5. Найти заявку по имени")
            .append(System.lineSeparator())
            .append("6. Выйти из меню")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdOut);
    }


    public void inputAndStart(String[] input) {
        new StartUI(new StubInput(input), this.tracker).init();
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        inputAndStart(new String[]{"0", "test name", "desc", "6"});
        assertThat(this.tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenShowAllThenTrackerHasAllValue() {
        inputAndStart(new String[]{"1", "6"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Начало списка всех заявок ----------")
                                .append(System.lineSeparator())
                                .append("Id заявки: " +  this.item.getId()
                                        + " Имя заявки: " + this.item.getName()
                                        + " Описание заявки: " + this.item.getDesc())
                                .append(System.lineSeparator())
                                .append("---------- Конец списка всех заявок ----------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        inputAndStart(new String[]{"2", this.item.getId(), "test replace", "заменили заявку", "6"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Редактирование заявки ----------")
                                .append(System.lineSeparator())
                                .append("---------- Изменения внесены успешно ----------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteThenTrackerHasNullValue() {
        inputAndStart(new String[]{"3", this.item.getId(), "6"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Удаление заявки ----------")
                                .append(System.lineSeparator())
                                .append("---------- Заявка успешно удалена ----------")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIdThenTrackerHasEqualIdValue() {
        inputAndStart(new String[]{"4", this.item.getId(), "6"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Поиск заявки по id ----------")
                                .append(System.lineSeparator())
                                .append("Id заявки: " +  this.item.getId()
                                        + " Имя заявки: " + this.item.getName()
                                        + " Описание заявки: " + this.item.getDesc())
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByNameThenTrackerHasEqualNameValue() {
        inputAndStart(new String[]{"5", this.item.getName(), "6"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Поиск заявки по имени ----------")
                                .append(System.lineSeparator())
                                .append("Id заявки: " +  this.item.getId()
                                        + " Имя заявки: " + this.item.getName()
                                        + " Описание заявки: " + this.item.getDesc())
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
}