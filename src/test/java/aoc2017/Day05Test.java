package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 05")
class Day05Test {
    private Day05 day = new Day05();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(5));
    }

    @Test
    public void solveProblem() throws IOException {
        int[] jumpArray = TestUtil.readResourceAsInts("/day05.txt");
        assertThat(day.doStuff(jumpArray), is(351282));
    }

    @Test
    public void simpleTest2() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff2(testInput), is(10));
    }

    @Test
    public void solveProblem2() throws IOException {
        int[] jumpArray = TestUtil.readResourceAsInts("/day05.txt");
        assertThat(day.doStuff2(jumpArray), is(24568703));
    }
}