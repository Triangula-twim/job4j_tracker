package ru.job4j.tracker.trackers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SFFSingleTest {

    @Test
    public void values() {
        assertSame(SFFSingle.getInstance(), SFFSingle.getInstance());
    }
}