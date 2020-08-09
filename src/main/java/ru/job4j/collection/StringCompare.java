package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        for (int i = 0; i < Math.min(firstLength, secondLength); i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            if (firstChar != secondChar) {
                return Character.compare(firstChar, secondChar);
            }
        }
        if (firstLength < secondLength) {
            return -1;
        } else if (firstLength > secondLength) {
            return 1;
        }
        return 0;
    }
}
