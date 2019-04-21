package ru.job4j.tracker.trakers;

import org.junit.Test;
import ru.job4j.tracker.Item;

import ru.job4j.tracker.trackers.TrackerSingle1;
import ru.job4j.tracker.trackers.TrackerSingle2;
import ru.job4j.tracker.trackers.TrackerSingle3;
import ru.job4j.tracker.trackers.TrackerSingle4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrakerSingleTest {


    @Test
    public void trackSingl1Test() {

        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker1 = TrackerSingle1.INSTANCE;

        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Item result2 = tracker1.findById(item.getId());
        assertThat(result.getName(), is(result2 .getName()));
        assertThat(tracker.equals(tracker1), is(true));
    }

    @Test
    public void trackSingl2Test() {
    TrackerSingle2 tracker = TrackerSingle2.getInstance();
    TrackerSingle2 tracker1 = TrackerSingle2.getInstance();

        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Item result2 = tracker1.findById(item.getId());
        assertThat(result.getName(), is(result2 .getName()));
        assertThat(tracker.equals(tracker1), is(true));
    }

    @Test
    public void trackSingl3Test() {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();

        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Item result2 = tracker1.findById(item.getId());
        assertThat(result.getName(), is(result2 .getName()));
        assertThat(tracker.equals(tracker1), is(true));
    }

    @Test
    public void trackSingl4Test() {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();

        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Item result2 = tracker1.findById(item.getId());
        assertThat(result.getName(), is(result2 .getName()));
        assertThat(tracker.equals(tracker1), is(true));
    }

}
