package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 05 - Part 1")
class Day05p1Test {
    private Day05p1 day = new Day05p1();

    @Test
    public void simpleTest() {
        // test stuff
        day.doStuff();
        assertThat(1, is(1));
    }
}