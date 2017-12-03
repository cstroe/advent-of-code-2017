package aoc2017;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test for simple Day001.
 */
@DisplayName("Advent of Code: Day 001")
public class Day001Test {
    private Day001 day;

    @BeforeEach
    public void setUp() {
        day = new Day001();
    }

    @Test @DisplayName("should compute a simple sum")
    public void simpleTests() {
        assertThat(day.getSum("1122"), is(3L));
    }

    @Test @DisplayName("should compute a repeated sum")
    public void repeatedSum() {
        assertThat(day.getSum("1111"), is(4L));
    }

    @Test @DisplayName("should compute a sum with no matches")
    public void noMatches() {
        assertThat(day.getSum("1234"), is(0L));
    }

    @Test @DisplayName("should compute a sum with only end matches")
    public void endMatch() {
        assertThat(day.getSum("91212129"), is(9L));
    }

    @Test @DisplayName("should compute a sum for an empty string")
    public void emptyString() {
        assertThat(day.getSum(""), is(0L));
    }

    @Test @DisplayName("should compute a sum for one digit")
    public void oneDigit() {
        assertThat(day.getSum("0"), is(0L));
        assertThat(day.getSum("1"), is(1L));
        assertThat(day.getSum("2"), is(2L));
        assertThat(day.getSum("3"), is(3L));
        assertThat(day.getSum("4"), is(4L));
        assertThat(day.getSum("5"), is(5L));
        assertThat(day.getSum("6"), is(6L));
        assertThat(day.getSum("7"), is(7L));
        assertThat(day.getSum("8"), is(8L));
        assertThat(day.getSum("9"), is(9L));
    }
}
