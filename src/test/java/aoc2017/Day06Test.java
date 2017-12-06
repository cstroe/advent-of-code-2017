package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 06 - Part 1")
class Day06Test {
    private Day06 day = new Day06();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 2, 7, 0};
        assertThat(day.doStuff(testInput), is(4));
    }

    @Test
    public void solveProblem() throws IOException {
        int[] input = TestUtil.readLineAsInts(0, "/day06.txt");
        assertThat(day.doStuff(input), is(1610));
    }
}
