package ru.job4j.list;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void filtr() {
        List<Integer> list = List.of(4, -3, 1, -1, 0);
        List<Integer> rsl = list.stream().filter(x -> x > 0).collect(Collectors.toList());
    }
}
