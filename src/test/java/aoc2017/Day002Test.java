package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Advent of Code: Day 02")
class Day002Test {
    @Nested @DisplayName("part 1")
    class Part1 {
        @Test @DisplayName("should compute example checksum")
        public void computeExampleChecksum() {
            Day002 day = new Day002();
            assertThat(day.computeChecksum(List.of("5 1 9 5", "7 5 3", "2 4 6 8")), is(18L));
        }

        @Test @DisplayName("should compute puzzle input checksum")
        public void computeInputChecksum() throws IOException {
            InputStream is = getClass().getResourceAsStream("/day002.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            List<String> rows = new LinkedList<>();
            while((line = reader.readLine()) != null) {
                rows.add(line);
            }

            Day002 day = new Day002();
            assertThat(day.computeChecksum(rows), is(42299L));
        }
    }

    @Nested @DisplayName("part 2")
    class Part2 {
        @Test @DisplayName("should compute example checksum")
        public void computeExampleChecksum() {
            Day002 day = new Day002();
            List<String> inputList = List.of("5 9 2 8", "9 4 7 3", "3 8 6 5");
            assertThat(day.computeDivisibleChecksum(inputList), is(9L));
        }

        @Test @DisplayName("should compute puzzle input checksum")
        public void computeInputChecksum() throws IOException {
            InputStream is = getClass().getResourceAsStream("/day002.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            List<String> rows = new LinkedList<>();
            while((line = reader.readLine()) != null) {
                rows.add(line);
            }

            Day002 day = new Day002();
            assertThat(day.computeDivisibleChecksum(rows), is(277L));
        }
    }
}