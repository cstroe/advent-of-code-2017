package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 05 - Part 1")
class Day05p1Test {
    private Day05p1 day = new Day05p1();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(5));
    }

    @Test
    public void solveProblem() throws IOException {
        List<String> jumpList = TestUtil.readResource("/day005.txt");
        int[] jumpArray = jumpList.stream().mapToInt(Integer::parseInt).toArray();

        assertThat(day.doStuff(jumpArray), is(351282));
    }
}