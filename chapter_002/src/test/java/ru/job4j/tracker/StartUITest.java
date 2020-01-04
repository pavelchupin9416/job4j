package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;


public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
   // private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();


    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    private StringJoiner menu = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
            .add("0 : Add new Item.")
            .add("1 : Show all items.")
            .add("2 : Edit item.")
            .add("3 : Delete item.")
            .add("4 : Find item by Id.")
            .add("5 : Find items by name.")
            .add("6 : Exit programm.");

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        //System.setOut(this.stdout);
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
         new StartUI(input, tracker, output).init();
       // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is(new StringBuilder()
                        .append(menu)
                        .append("------------ Все заявки --------------")
                        .append(System.lineSeparator())
                        .append("id:" + tracker.findAll().get(0).getId() + " name:test1 decs:testDescription")
                        .append(System.lineSeparator())
                        .append("id:" + tracker.findAll().get(1).getId() + " name:test2 decs:testDescription2")
                        .append(System.lineSeparator())
                        .append(menu)
                        .append("Выход из программы")
                        .append(System.lineSeparator())
                        .toString()


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
        new StartUI(input, tracker, output).init();
        // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is(new StringBuilder()
                        .append(menu)
                        .append("------------ Получение заявки --------------")
                        .append(System.lineSeparator())
                        .append("------------ Заявка с id:" + tracker.findAll().get(0).getId() + " name:" + tracker.findAll().get(0).getName()
                         + " decs:" + tracker.findAll().get(0).getDecs() + " -----------")
                        .append(System.lineSeparator())
                        .append(menu)
                        .append("Выход из программы")
                        .append(System.lineSeparator())
                        .toString()


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
        new StartUI(input, tracker, output).init();
        // assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(
                this.out.toString(),
                Is.is(new StringBuilder()
                        .append(menu)
                        .append("------------ Получение заявок --------------")
                        .append(System.lineSeparator())
                        .append("id:" + tracker.findAll().get(0).getId() + " name:" + tracker.findAll().get(0).getName()
                                + " decs:" + tracker.findAll().get(0).getDecs())
                        .append(System.lineSeparator())
                        .append("id:" + tracker.findAll().get(2).getId() + " name:" + tracker.findAll().get(0).getName()
                                + " decs:" + tracker.findAll().get(2).getDecs())
                        .append(System.lineSeparator())
                        .append(menu)
                        .append("Выход из программы")
                        .append(System.lineSeparator())
                         .toString()


                )
        );
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        new StartUI(input, tracker, output).init();
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
        new StartUI(input, tracker, output).init();
        List<Item> result = Arrays.asList(second);
        assertThat(tracker.findAll(), is(result));
    }


}
