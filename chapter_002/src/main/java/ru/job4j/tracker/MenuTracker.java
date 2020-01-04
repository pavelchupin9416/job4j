package ru.job4j.tracker;

import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    private final Consumer<String> output;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();



    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item."));
        this.actions.add(new ShowItems(1, "Show all items."));
        this.actions.add(new UpdateItem(2, "Edit item."));
        this.actions.add(new DeleteItem(3, "Delete item."));
        this.actions.add(new FindItemById(4, "Find item by Id."));
        this.actions.add(new FindItemsByName(5, "Find items by name."));
        this.actions.add(new Exit(6, "Exit programm.", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }


    private class Exit extends BaseAction {
        private final StartUI ui;

        public Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("Выход из программы");
            this.ui.stop();
        }
    }


    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, 1);
            tracker.add(item);
            output.accept("------------ New Item with Id : " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDecs());
        }
    }

   /* private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, 1);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDecs());
        }

        @Override
        public String info() {
            return "0. Add new Item.";
        }
    }*/

    private class ShowItems extends BaseAction {


        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Все заявки --------------");
            List<Item> result = tracker.findAll();
            for (Item rst : result) {
                output.accept("id:" + rst.getId() + " name:" + rst.getName() + " decs:" + rst.getDecs());
            }
        }


    }

    private class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Замена заявки заявки --------------");
            String id = input.ask("Введите id заменяемой заявки :");
            String name = input.ask("Введите имя новой заявки :");
            String desc = input.ask("Введите описание новой заявки :");
            Item item = new Item(name, desc, 123);
            boolean result = tracker.replace(id, item);
            if (result) {
                output.accept("------------ Новая заявка с getId : " + item.getId() + " name:" + item.getName() + "-----------");
            } else {
                output.accept("------------заявки с данным id не существует-----------");
            }
        }

    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите id удаляемой заявки :");
            boolean result = tracker.delete(id);
            if (result) {
                output.accept("------------ Заявка с getId : " + id + " удалена-----------");
            } else {
                output.accept("------------заявки с данным id не существует-----------");
            }
        }

    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Получение заявки --------------");
            String id = input.ask("Введите id заявки :");
            Item result = tracker.findById(id);
            if (result != null) {
                output.accept("------------ Заявка с id:" + result.getId() + " name:" + result.getName() + " decs:" + result.getDecs() + " -----------");
            } else {
                output.accept("------------заявки с данным id не существует-----------");
            }
        }


    }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }


        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Получение заявок --------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> result = tracker.findByName(name);
            if (result != null) {
                for (Item rst : result) {
                    output.accept("id:" + rst.getId() + " name:" + rst.getName() + " decs:" + rst.getDecs());
                }
            } else {
                output.accept("------------заявки с данным именем не существует-----------");
            }
        }


    }

}