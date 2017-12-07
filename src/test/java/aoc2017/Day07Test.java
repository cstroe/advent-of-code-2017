package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 07")
class Day07Test {
    private Day07 day = new Day07();

    @Test
    public void simpleTest() throws IOException {
        List<String> testInput = TestUtil.readResource("/day07test.txt");

        assertThat(day.getBottomTower(testInput), is("tknk"));
    }

    @Test
    public void solveProblem() throws IOException {
        List<String> input = TestUtil.readResource("/day07.txt");
        assertThat(day.findCorrectWeight(input), is(""));
    }
}
