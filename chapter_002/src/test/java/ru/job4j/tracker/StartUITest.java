package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.function.Consumer;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private final Tracker tracker = new Tracker();

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final PrintStream stdOut = System.out;

    private final Consumer<String> outPut = new Consumer<String>() {
        PrintWriter printWriter = new PrintWriter(out);
        @Override
        public void accept(String s) {
            printWriter.write(s);
            printWriter.flush();
            System.out.println();
        }
    };

    private final StringBuilder menu = new StringBuilder()
            .append("Меню")
            .append(System.lineSeparator())
            .append("0. Добавление новой заявки.")
            .append(System.lineSeparator())
            .append("1. Показать все заявки.")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку.")
            .append(System.lineSeparator())
            .append("3. Удалить заявку.")
            .append(System.lineSeparator())
            .append("4. Найти заявку по id.")
            .append(System.lineSeparator())
            .append("5. Найти заявку по имени.")
            .append(System.lineSeparator());

    private final Item item = this.tracker.add(new Item("test name", "desc"));

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdOut);
    }


    public void inputAndStart(String[] input) {
        new StartUI(new StubInput(input), this.tracker, outPut).init();
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        inputAndStart(new String[]{"0", "test name", "desc", "y"});
        assertThat(this.item.getName(), is("test name"));
    }

    @Test
    public void whenShowAllThenTrackerHasAllValue() {
        inputAndStart(new String[]{"1", "y"});
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(this.menu)
                                .append("---------- Начало списка всех заявок ----------")
                                .append(System.lineSeparator())
                                .append("Id заявки: " +  this.item.getId()
                                        + " Имя заявки: " + this.item.getName()
                                        + " Описание заявки: " + this.item.getDesc())
                                .append(System.lineSeparator())
                                .append("---------- Конец списка всех заявок ----------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        inputAndStart(new String[]{"2", this.item.getId(), "test replace", "заменили заявку", "y"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Редактирование заявки ----------")
                                .append(System.lineSeparator())
                                .append("---------- Изменения внесены успешно ----------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDeleteThenTrackerHasNullValue() {
        inputAndStart(new String[]{"3", this.item.getId(), "y"});
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Удаление заявки ----------")
                                .append(System.lineSeparator())
                                .append("---------- Заявка успешно удалена ----------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIdThenTrackerHasEqualIdValue() {
        inputAndStart(new String[]{"4", this.item.getId(), "y"});
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
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByNameThenTrackerHasEqualNameValue() {
        inputAndStart(new String[]{"5", this.item.getName(), "y"});
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
                                .toString()
                )
        );
    }
}