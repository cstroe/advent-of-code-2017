package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 05 - Part 2")
class Day05p2Test {
    private Day05p2 day = new Day05p2();
    @Test
    public void simpleTest() {
        // test stuff
        day.doStuff();
        assertThat(1, is(1));

    }
}