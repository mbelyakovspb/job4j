package ru.job4j.tracker;
/**
 * Класс StartUI
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 12.06.2019
 * @version 1
 */
public class StartUI {
    /**
     * Константа меню для добавления заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех имеющихся заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа меню для выхода из меню пользователя.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Выберите и введите пункт меню:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавление новой заявки
     */
    public void createItem() {
        System.out.println("---------- Добавление новой заявки ----------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("---------- Новая заявка с getId : " + item.getId() + "----------");
    }
    /**
     * Метод реализует добавление новой заявки
     */
    public void showAllItem() {
        System.out.println("---------- Начало списка всех заявок ----------");
        for (Item item : this.tracker.findAll()) {
            System.out.println(item.toString());
        }
        System.out.println("---------- Конец списка всех заявок ----------");
    }
    /**
     * Метод реализует редактирование заявки
     */
    public void editItem() {
        System.out.println("---------- Редактирование заявки ----------");
        String id = this.input.ask("Введите id заявки : ");
        String name = this.input.ask("Внесите изменения в имя заявки : ");
        String desc = this.input.ask("Внесите изменения в описание заявки : ");
        tracker.replace(id, new Item(name, desc));
        System.out.println("---------- Изменения внесены успешно ----------");
    }
    /**
     * Метод реализует удаление заявки
     */
    public void deleteItem() {
        System.out.println("---------- Редактирование заявки ----------");
        String id = this.input.ask("Введите id заявки : ");
        tracker.delete(id);
        System.out.println("---------- Заявка успешно удалена ----------");
    }
    /**
     * Метод реализует поиск заявки по id
     */
    public void findItemById() {
        System.out.println("---------- Поиск заявки по id ----------");
        String id = this.input.ask("Введите id заявки : ");
        System.out.println(tracker.findById(id).toString());
    }
    /**
     * Метод реализует поиск заявки по имени
     */
    public void findItemByName() {
        System.out.println("---------- Поиск заявки по имени ----------");
        String name = this.input.ask("Введите имя заявки : ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item.toString());
        }
    }
    /**
     * Метод выводит меню пользователю.
     */
    public void showMenu() {
        System.out.println("Меню");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти из меню");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
