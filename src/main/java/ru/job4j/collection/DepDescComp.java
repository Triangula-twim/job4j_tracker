package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        String[] firstSplit = first.split("/");
        String[] secondSplit = second.split("/");
        int rsl = secondSplit[0].compareTo(firstSplit[0]);
        if (rsl == 0) {
            rsl = first.compareTo(second);
        }
        return rsl;

    }
}
