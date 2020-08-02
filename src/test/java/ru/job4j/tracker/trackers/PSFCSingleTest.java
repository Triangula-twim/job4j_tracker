package ru.job4j.tracker.trackers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PSFCSingleTest {

    @Test
    public void values() {
        assertSame(PSFCSingle.getInstance(), PSFCSingle.getInstance());
    }

}