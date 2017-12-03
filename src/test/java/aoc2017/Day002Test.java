package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Day002Test {
    private Day002 day;

    @BeforeEach
    public void setUp() {
        day = new Day002();
    }

    @Test
    @DisplayName("should compute the correct sums")
    public void simpleTests() {
        assertThat(day.getSum("1212"), is(6L));
        assertThat(day.getSum("1111"), is(4L));
        assertThat(day.getSum("1234"), is(0L));
        assertThat(day.getSum("1221"), is(0L));
        assertThat(day.getSum(""), is(0L));
    }

    @Test @DisplayName("validate input size is even")
    public void validateSize() {
        assertThrows(IllegalArgumentException.class, () -> day.getSum("123"));
    }
}