package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Advent of Code: Day 03")
class Day003Test {
    @Nested @DisplayName("part 1")
    class Part1 {
        @Test @DisplayName("should find the ring the port is on")
        public void findRing() {
            Day003 day = new Day003();
            assertThat(day.findRing(1).num, is(1L));
            assertThat(day.findRing(3).num, is(2L));
            assertThat(day.findRing(6).num, is(2L));
            assertThat(day.findRing(8).num, is(2L));
            assertThat(day.findRing(9).num, is(2L));
            assertThat(day.findRing(10).num, is(3L));
            assertThat(day.findRing(49).num, is(4L));
            assertThat(day.findRing(80).num, is(5L));
            assertThat(day.findRing(80).base, is(9L));
            assertThat(day.findRing(82).num, is(6L));
            assertThat(day.findRing(82).base, is(11L));
        }

        @Test @DisplayName("ring should compute correct number of maxSteps")
        public void ringSteps() {
            {
                Day003.Ring ring = new Day003.Ring();
                assertThat(ring.num, is(1L));
                assertThat(ring.base, is(1L));
                assertThat(ring.maxSteps(), is(0L));
                assertThat(ring.minSteps(), is(0L));
            }{
                Day003.Ring ring = new Day003.Ring(2, 3);
                assertThat(ring.num, is(2L));
                assertThat(ring.base, is(3L));
                assertThat(ring.maxSteps(), is(2L));
                assertThat(ring.minSteps(), is(1L));
            }{
                Day003.Ring ring = new Day003.Ring(3, 5);
                assertThat(ring.num, is(3L));
                assertThat(ring.base, is(5L));
                assertThat(ring.maxSteps(), is(4L));
                assertThat(ring.minSteps(), is(2L));
            }

        }

        @Test @DisplayName("should compute the number of maxSteps for a port")
        public void findSteps() {
            Day003 day = new Day003();
            assertThat(day.computeSteps(25), is(4L));
            assertThat(day.computeSteps(24), is(3L));
            assertThat(day.computeSteps(23), is(2L));
            assertThat(day.computeSteps(22), is(3L));
            assertThat(day.computeSteps(21), is(4L));
            assertThat(day.computeSteps(20), is(3L));
        }

        @Test @DisplayName("should solve puzzle")
        public void solvePuzzlePart1() {
            Day003 day = new Day003();
            assertThat(day.computeSteps(347991), is(480L));
        }
    }

    @Nested @DisplayName("part 2")
    class Part2 {
        @Test @DisplayName("")
        public void testCellGeneration() {
            // first ring
            Day003.Cell cell01 = Day003.Cell.firstCell();
            assertThat(cell01.value, is(1L));

            // second ring
            Day003.Cell cell02 = cell01.next();
            assertThat(cell02.value, is(1L));
            Day003.Cell cell03 = cell02.next();
            assertThat(cell03.value, is(2L));
            Day003.Cell cell04 = cell03.next();
            assertThat(cell04.value, is(4L));
            Day003.Cell cell05 = cell04.next();
            assertThat(cell05.value, is(5L));
            Day003.Cell cell06 = cell05.next();
            assertThat(cell06.value, is(10L));
            Day003.Cell cell07 = cell06.next();
            assertThat(cell07.value, is(11L));
            Day003.Cell cell08 = cell07.next();
            assertThat(cell08.value, is(23L));
            Day003.Cell cell09 = cell08.next();
            assertThat(cell09.value, is(25L));

            // third ring
            Day003.Cell cell10 = cell09.next();
            assertThat(cell10.value, is(26L));
            Day003.Cell cell11 = cell10.next();
            assertThat(cell11.value, is(54L));
            Day003.Cell cell12 = cell11.next();
            assertThat(cell12.value, is(57L));
            Day003.Cell cell13 = cell12.next();
            assertThat(cell13.value, is(59L));
            Day003.Cell cell14 = cell13.next();
            assertThat(cell14.value, is(122L));
            Day003.Cell cell15 = cell14.next();
            assertThat(cell15.value, is(133L));
            Day003.Cell cell16 = cell15.next();
            assertThat(cell16.value, is(142L));
            Day003.Cell cell17 = cell16.next();
            assertThat(cell17.value, is(147L));
            Day003.Cell cell18 = cell17.next();
            assertThat(cell18.value, is(304L));
            Day003.Cell cell19 = cell18.next();
            assertThat(cell19.value, is(330L));
            Day003.Cell cell20 = cell19.next();
            assertThat(cell20.value, is(351L));
            Day003.Cell cell21 = cell20.next();
            assertThat(cell21.value, is(362L));
            Day003.Cell cell22 = cell21.next();
            assertThat(cell22.value, is(747L));
            Day003.Cell cell23 = cell22.next();
            assertThat(cell23.value, is(806L));
        }
    }

    @Test @DisplayName("solve puzzle")
    public void solvePuzzle() {
        Day003.Cell currentCell = Day003.Cell.firstCell();
        while(currentCell.value < 347991) {
            currentCell = currentCell.next();
        }
        System.out.println("First value written larger than puzzle input: " + currentCell.value);
    }
}