package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        var priorityQueue = new PriorityQueue();
        priorityQueue.put(new Task("Низкий уровень", 4));
        priorityQueue.put(new Task("Средний уровень", 3));
        priorityQueue.put(new Task("Самый высокий уровень", 1));
        priorityQueue.put(new Task("Высокий уровень", 2));
        var result = priorityQueue.take();
        assertThat(result.getDesc(), is("Самый высокий уровень"));
    }
}