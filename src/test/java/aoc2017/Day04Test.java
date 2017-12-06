package aoc2017;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day 04 - Part 1")
class Day04Test {
    private Day04 day;

    @BeforeEach
    public void setUp() {
        day = new Day04();
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

    @Test
    public void simpleTest2() {
        assertThat(day.countValidPasswords2(List.of("abcde fghij")), is(1));
        assertThat(day.countValidPasswords2(List.of("abcde xyz ecdab")), is(0));
    }

    @Test
    public void solvePuzzlePart2() throws IOException {
        List<String> passwords = TestUtil.readResource("/day004.txt");
        System.out.println("Found " + passwords.size() + " passwords.");

        int validPasswords = day.countValidPasswords2(passwords);
        System.out.println("Found " + validPasswords + " valid passwords.");
    }
}