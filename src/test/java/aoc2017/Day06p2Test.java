package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 06 - Part 2")
class Day06p2Test {
    private Day06p2 day = new Day06p2();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(0));
    }

    @Test
    public void solveProblem() throws IOException {
        int[] input = TestUtil.readResourceAsInts("/day06.txt");
        assertThat(day.doStuff(input), is(0));
    }
}
