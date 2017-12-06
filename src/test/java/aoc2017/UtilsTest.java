package aoc2017;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UtilsTest {
    @Test
    public void maxIndex() {
        assertThat(Utils.findMaxIndex(new int[] {1, 7, 5, 3}), is(1));
        assertThat(Utils.findMaxIndex(new int[] {-100, -99, 3, -1}), is(2));
    }
}