package ru.job4j.list;
/**
 * Класс SimpleArrayList
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 25.02.2020
 * @version 1
 */
public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     * @param data - параметризованный объект
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * Реализовать метод удаления первого элемент в списке.
     * @return - параметризованный объект
     */
    public E delete() {
        E result = this.first.data;
        this.first = this.first.next;
        this.size--;
        return result;
    }
    /**
     * Метод получения элемента по индексу.
     * @return - параметризованный объект
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Приватный класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
