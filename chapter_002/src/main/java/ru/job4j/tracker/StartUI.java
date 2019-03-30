package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    /**
     * Константа для выхода из цикла.
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
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
           } else if (ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItems();
            } else if (DELETE.equals(answer)) {
                this.deleteItems();
            } else if (ID.equals(answer)) {
                this.idItems();
            } else if (NAME.equals(answer)) {
                this.nameItems();
//             Добавить остальные действия системы по меню.
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 123);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод показывает все заявки в хранилище.
     */
    private void showAllItems() {
        System.out.println("------------ Все заявки --------------");
        Item[] result = this.tracker.findAll();
        for (Item rst : result) {
            System.out.println("id:" + rst.getId() + " name:" + rst.getName() + " decs:" + rst.getDecs());
        }
    }


    /**
     * Метод заменяет заявку в хранилище.
     */
    private void editItems() {
        System.out.println("------------ Замена заявки заявки --------------");
        String id = this.input.ask("Введите id заменяемой заявки :");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc, 123);
        boolean result = this.tracker.replace(id, item);
        if (result) {
            System.out.println("------------ Новая заявка с getId : " + item.getId() + " name:" + item.getName() + "-----------");
        } else {
            System.out.println("------------заявки с данным id не существует-----------");
        }
    }

    /**
     * Метод удаляет заявку в хранилище.
     */
    private void deleteItems() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id удаляемой заявки :");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("------------ Заявка с getId : " + id + " удалена-----------");
        } else {
            System.out.println("------------заявки с данным id не существует-----------");
        }
    }

    /**
     * Метод возращает заявку по id из хранилища.
     */
    private void idItems() {
        System.out.println("------------ Получение заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("------------ Заявка с id:" + result.getId() + " name:" + result.getName() + " decs:" + result.getDecs() + " -----------");
        } else {
            System.out.println("------------заявки с данным id не существует-----------");
        }
    }

    /**
     * Метод возращает заявки по name из хранилища.
     */
    private void nameItems() {
        System.out.println("------------ Удаление заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = this.tracker.findByName(name);
        if (result != null) {
            for (Item rst : result) {
                System.out.println("id:" + rst.getId() + " name:" + rst.getName() + " decs:" + rst.getDecs());
            }
        } else {
            System.out.println("------------заявки с данным именем не существует-----------");
        }
    }



    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}