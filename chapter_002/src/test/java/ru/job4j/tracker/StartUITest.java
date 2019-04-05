package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;




public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenFindAllThenItemsAll() {
        Tracker tracker = new Tracker();     // создаём Tracker
        tracker.add(new Item("test1", "testDescription", 1L));
        tracker.add(new Item("test2", "testDescription2", 2L));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
       // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is("Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "------------ Все заявки --------------\r\n"
                        + "id:" + tracker.findAll()[0].getId() + " name:test1 decs:testDescription\r\n"
                        + "id:" + tracker.findAll()[1].getId() + " name:test2 decs:testDescription2\r\n"
                        + "Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                )
        );
    }


    @Test
    public void whenFindIdThenTtemId() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item first = tracker.add(new Item("test1", "testDescription", 1L));
        tracker.add(new Item("test2", "testDescription2", 2L));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"4", first.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is("Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "------------ Получение заявки --------------\r\n"
                        + "------------ Заявка с id:" + tracker.findAll()[0].getId() + " name:" + tracker.findAll()[0].getName()
                        + " decs:" + tracker.findAll()[0].getDecs() + " -----------\r\n"
                        + "Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                )
        );
    }


    @Test
    public void whenFindNameThenIntemsName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Item first = tracker.add(new Item("test1", "testDescription", 1L));
        tracker.add(new Item("test2", "testDescription2", 2L));
        tracker.add(new Item("test1", "testDescription3", 3L));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"5", first.getName(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is("Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "------------ Получение заявок --------------\r\n"
                        + "id:" + tracker.findAll()[0].getId() + " name:" + tracker.findAll()[0].getName()
                        + " decs:" + tracker.findAll()[0].getDecs() + "\r\n"
                        + "id:" + tracker.findAll()[2].getId() + " name:" + tracker.findAll()[0].getName()
                        + " decs:" + tracker.findAll()[0].getDecs() + "\r\n"
                        + "Меню.\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                )
        );
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 1));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeleteValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item first = tracker.add(new Item("test1", "testDescription", 1L));
        Item second = tracker.add(new Item("test2", "testDescription2", 2L));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"3", first.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        Item[] result = new Item[] {second};
        assertThat(tracker.findAll(), is(result));
    }


}
