package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Day004Test {
    private Day004 day;

    @BeforeEach
    public void setUp() {
        day = new Day004();
    }

    @Test
    public void simpleTest() {
        assertThat(day.countValidPasswords(List.of("aa bb cc dd ee")), is(1));
    }

    @Test
    public void solvePuzzlePart1() throws IOException {
        List<String> passwords = TestUtil.readResource("/day004.txt");
        System.out.println("Found " + passwords.size() + " passwords.");

        int validPasswords = day.countValidPasswords(passwords);
        System.out.println("Found " + validPasswords + " valid passwords.");
    }
}