package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Класс DynamicArray
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 25.02.2020
 * @version 1
 */
public class DynamicArray<E> implements Iterable<E> {

    private Object[] container = new Object[2];
    private int index;
    private int modCount;
    /**
     * Метод вставляет данные в список.
     * @param data - параметризованный объект
     * @return -
     */
    public void add(E data) {
        if (container.length == index) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
            modCount++;
        }
        this.container[index++] = data;
    }
    /**
     * Метод получает данные из списка.
     * @param index - номер ячейки в списке
     * @return - возвращает объект по значению index
     */
    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return position < index;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}
