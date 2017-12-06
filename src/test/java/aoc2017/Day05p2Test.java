package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 05 - Part 2")
class Day05p2Test {
    private Day05p2 day = new Day05p2();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(10));
    }

    @Test
    public void solveProblem() throws IOException {
        int[] jumpArray = TestUtil.readResourceAsInts("/day5.txt");
        assertThat(day.doStuff(jumpArray), is(24568703));
    }
}