package ru.job4j.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    public static List<Address> collectUniq(List<Address> addresses) {
        addresses.sort(Comparator.naturalOrder());
        return addresses.stream().distinct().collect(Collectors.toList());
    }
}
