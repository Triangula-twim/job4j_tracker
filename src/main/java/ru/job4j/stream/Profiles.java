package ru.job4j.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> rsl = profiles.stream().map(profile ->
                profile.getAddress()).collect(Collectors.toList());
        rsl.sort(Comparator.naturalOrder());
        return rsl.stream().distinct().collect(Collectors.toList());
    }
}
