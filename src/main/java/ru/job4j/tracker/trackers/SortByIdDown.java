package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByIdDown implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(second.getId(), first.getId());
    }
}
