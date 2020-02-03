package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Параметризованный класс SimpleArray
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 01.02.2020
 * @version 1
 */
public class SimpleArray<T> {
    private final Object[] objects;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * Метод add добавляет объекте в массив класса SimpleArray
     * @param model - добавляет элемент в параметризованный класс
     */
    public void add(T model) {
        this.objects[position++] = model;
    }
    /**
     * Метод checkIndex проверяет index на возможность выхода за границы массива
     * @param index - номер ячейки, в которой находится нужный элемент
     */
    public boolean checkIndex(int index) {
        if (index >= this.position || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
    /**
     * Метод set устанавливает другое значение в существующий элемент массива класса SimpleArray
     * @param model - добавляет элемент в параметризованный класс
     * @param index - номер ячейки, в которой находится перезаписываемый элемент
     */
    public void set(int index, T model) {
        checkIndex(index);
        this.objects[index] = model;
    }
    /**
     * Метод get получает другое значение в существующий элемент массива класса SimpleArray
     * @param index - номер ячейки, в которой находится нужный элемент
     */
    public T get(int index) {
        checkIndex(index);
        return (T) this.objects[index];
    }
    /**
     * Метод remove удаляет значение вместе с ячейкой в массиве класса SimpleArray
     * @param index - номер ячейки, в которой находится нужный элемент
     */
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(this.objects, index + 1,
                this.objects, index, this.objects.length - 1 - index);
        this.position--;
    }
    /**
     * Метод iterator для класса SimpleArray
     */
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[index++];
            }
        };
    }
}