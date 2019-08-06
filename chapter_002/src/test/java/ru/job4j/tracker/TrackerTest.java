package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindItemByNameThenTrackerFindsAllItemWithThatName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 125L);
        tracker.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item1);
        assertThat(tracker.findByName("test1"), is(expected));
    }

    @Test
    public void whenFindItemByIdThenTrackerFindsItemWithThatId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 125L);
        tracker.add(item2);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test2", "testDescription2", 124L);
        item1.setId(item.getId());
        tracker.replace(item.getId(), item1);
        assertThat(tracker.findById(item.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAllItemThenReturnAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 125L);
        tracker.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item1);
        expected.add(item2);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenDeleteOneFromThreeElements() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription", 125L);
        tracker.add(item2);
        tracker.delete(item2.getId());
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item1);
        assertThat(tracker.findAll(), is(expected));
    }
}