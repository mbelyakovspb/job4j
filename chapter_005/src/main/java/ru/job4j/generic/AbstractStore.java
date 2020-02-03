package ru.job4j.generic;
/**
 * Абстрактный класс AbstractStore
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.02.2020
 * @version 1
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private final SimpleArray<T> simpleArray;

    private final int size;

    public AbstractStore(int size) {
        this.size = size;
        this.simpleArray = new SimpleArray<>(size);
    }
    /**
     * Метод add добавляет объект model типа T
     * @param model - объект model типа T
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }
    /**
     * Метод replace находит объект по id и меняет его на другой объект model типа T
     * @param model - объект model типа T
     * @param id - номер ячейки, в которой находится перезаписываемый объект
     * @return true - если объект заменен
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int index = 0; index < this.size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                simpleArray.set(index, model);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод delete находит объект по id и удадяет его
     * @param id - номер ячейки, в которой находится удаляемый объект
     * @return true - если объект удален
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                simpleArray.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод findById находит объект по id
     * @param id - номер ячейки, в которой находится удаляемый объект
     * @return объект типа T
     */
    @Override
    public T findById(String id) {
        T result = null;
        for (int index = 0; index < size; index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                result = simpleArray.get(index);
                break;
            }
        }
        return result;
    }
}
