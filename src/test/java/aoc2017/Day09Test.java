package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static aoc2017.Utils.*;

@DisplayName("Day 09")
class Day09Test {
    private Day09 day = new Day09();

    @BeforeEach
    public void setUp() {
        day = new Day09();
    }

    @Test
    public void solvePart1() throws IOException {
        List<String> strings = TestUtil.readResource("/day09.txt");
        assertThat(day.part1(strings.get(0), true), is(9662));
    }

    @Test
    public void testPart2() throws IOException {
        assertThat(day.part1("<{o\"i!a,<{i<a>", false), is(10));
    }

    @Test
    public void solvePart2() throws IOException {
        List<String> strings = TestUtil.readResource("/day09.txt");
        assertThat(day.part1(strings.get(0), false), is(4903));
    }
}
