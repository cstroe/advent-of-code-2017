package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Day004p2Test {
    private Day004p2 day;

    @BeforeEach
    public void setUp() {
        day = new Day004p2();
    }

    @Test
    public void simpleTest() {
        assertThat(day.countValidPasswords(List.of("abcde fghij")), is(1));
        assertThat(day.countValidPasswords(List.of("abcde xyz ecdab")), is(0));
    }

    @Test
    public void solvePuzzlePart1() throws IOException {
        List<String> passwords = TestUtil.readResource("/day004.txt");
        System.out.println("Found " + passwords.size() + " passwords.");

        int validPasswords = day.countValidPasswords(passwords);
        System.out.println("Found " + validPasswords + " valid passwords.");
    }
}