package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        if (first.compareTo(second) > 0) {
            return -1;
        } else if (first.compareTo(second) < 0) {
            return 1;
        }
        return 0;
    }
}
