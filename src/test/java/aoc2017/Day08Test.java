package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static aoc2017.Utils.*;

@DisplayName("Day 08")
class Day08Test {
    private Day08 day;

    @BeforeEach
    public void setUp() {
        day = new Day08();
    }

    @Test
    public void testPart1() throws IOException {
        List<String> input = TestUtil.readResource("/day08test.txt");
        assertThat(day.part1(input), is(1));
    }

    @Test
    public void solvePart1() throws IOException {
        List<String> input = TestUtil.readResource("/day08.txt");
        assertThat(day.part1(input), is(8022));
    }


    @Test
    public void testPart2() throws IOException {
        List<String> input = TestUtil.readResource("/day08test.txt");
        assertThat(day.part2(input), is(10));
    }

    @Test
    public void solvePart2() throws IOException {
        List<String> input = TestUtil.readResource("/day08.txt");
        assertThat(day.part2(input), is(9819));
    }
}
