package ru.job4j.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ToStringInt {

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );
        List<Integer> rsl = matrix.stream().flatMap(Collection::stream).
                collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
