package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String[] firstStringSplit = first.split(". ");
        String[] secondStringSplit = second.split(". ");
        return Integer.compare(Integer.parseInt(firstStringSplit[0])
                , Integer.parseInt(secondStringSplit[0]));
    }
}
