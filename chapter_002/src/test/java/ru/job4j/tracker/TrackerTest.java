package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenFindByIdReturnItemThisIDItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        assertThat(tracker.findById(previous.getId()), is(previous));
    }

    @Test
    public void whenFindAllThenRetrunAllItem() {
        Tracker tracker = new Tracker();
        Item[] previous = new Item[] {new Item("test1", "testDescription1", 1L),
                                        new Item("test2", "testDescriptio2", 2L),
                                        new Item("test3", "testDescription3", 3L)};
        tracker.add(previous[0]);
        tracker.add(previous[1]);
        tracker.add(previous[2]);
        assertThat(tracker.findAll(), is(previous));
    }

    @Test
    public void whenFindByNameReturnItemThisSameName() {
        Tracker tracker = new Tracker();
        Item[] previous = new Item[] {new Item("test1", "testDescription1", 1L),
                new Item("test2", "testDescriptio2", 2L),
                new Item("test1", "testDescription3", 3L)};
        tracker.add(previous[0]);
        tracker.add(previous[1]);
        tracker.add(previous[2]);
        String name = previous[0].getName();
        Item[] result = new Item[] {previous[0], previous[2]};
        assertThat(tracker.findByName(name), is(result));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


    @Test
    public void whenDeleteItemIDThenReturnItemWithoutItemID() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 1L);
        Item second = new Item("test2", "testDescription2", 2L);
        Item three = new Item("test3", "testDescription3", 3L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(three);
        tracker.delete(second.getId());
        Item[] result = new Item[] {first, three};
        assertThat(tracker.findAll(), is(result));
    }
}