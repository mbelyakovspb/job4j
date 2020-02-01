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
    private Object[] objects;
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
     * Метод set устанавливает другое значение в существующий элемент массива класса SimpleArray
     * @param model - добавляет элемент в параметризованный класс
     * @param index - номер ячейки, в которой находится перезаписываемый элемент
     */
    public boolean set(int index, T model) {
        boolean result = false;
        this.objects[index] = model;
        if (this.objects[index].equals(model)) {
            result = true;
        }
        return result;
    }
    /**
     * Метод get получает другое значение в существующий элемент массива класса SimpleArray
     * @param index - номер ячейки, в которой находится нужный элемент
     */
    public T get(int index) {
        return (T) this.objects[index];
    }
    /**
     * Метод remove удаляет значение вместе с ячейкой в массиве класса SimpleArray
     * @param index - номер ячейки, в которой находится нужный элемент
     */
    public boolean remove(int index) {
        if (index < this.position && index >= 0) {
            System.arraycopy(this.objects, index + 1,
                    this.objects, index, this.objects.length - 1 - index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return true;
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