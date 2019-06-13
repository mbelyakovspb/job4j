package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenShowAllThenTrackerHasAllValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item.getName()));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNullValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.delete(item.getId()), is(true));
    }

    @Test
    public void whenFindItemByIdThenTrackerHasEqualIdValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenFindItemByNameThenTrackerHasEqualNameValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
}