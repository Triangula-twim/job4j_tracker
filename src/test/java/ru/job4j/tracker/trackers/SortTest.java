package ru.job4j.tracker.trackers;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void sortByNameUp() {
        List<Item> items = new ArrayList<Item>();
        Item first = new Item("c");
        Item second = new Item("d");
        Item third = new Item("a");
        items.add(first);
        items.add(second);
        items.add(third);
        Collections.sort(items, new SortByNameUp());
        List<Item> expected = new ArrayList<Item>();
        expected.add(third);
        expected.add(first);
        expected.add(second);
        assertEquals(items, expected);
    }

    @Test
    public void sortByNameDown() {
        List<Item> items = new ArrayList<Item>();
        Item first = new Item("a");
        Item second = new Item("d");
        Item third = new Item("c");
        items.add(first);
        items.add(second);
        items.add(third);
        Collections.sort(items, new SortByNameDown());
        List<Item> expected = new ArrayList<Item>();
        expected.add(second);
        expected.add(third);
        expected.add(first);
        assertEquals(items, expected);
    }

    @Test
    public void sortByIdUp() {
        List<Item> items = new ArrayList<Item>();
        Item first = new Item("c");
        Item second = new Item("d");
        Item third = new Item("a");
        first.setId(5);
        second.setId(2);
        third.setId(1);
        items.add(first);
        items.add(second);
        items.add(third);
        Collections.sort(items);
        List<Item> expected = new ArrayList<Item>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        assertEquals(items, expected);
    }

    @Test
    public void sortByIdDown() {
        List<Item> items = new ArrayList<Item>();
        Item first = new Item("c");
        Item second = new Item("d");
        Item third = new Item("a");
        first.setId(1);
        second.setId(2);
        third.setId(5);
        items.add(first);
        items.add(second);
        items.add(third);
        Collections.sort(items, new SortByIdDown());
        List<Item> expected = new ArrayList<Item>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        assertEquals(items, expected);
    }
}