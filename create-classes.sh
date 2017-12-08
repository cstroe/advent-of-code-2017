#!/usr/bin/env bash

#set -x

if [ -z "$1" ]; then
  echo "Usage: $0 <day>"
  echo "Example: $0 5"
  exit 1
fi

DAY=`printf "%02d" $1`

cat <<__IMPL__ > src/main/java/aoc2017/Day${DAY}.java
package aoc2017;

import java.util.*;
import java.util.stream.Collectors;

import static aoc2017.Utils.*;

public class Day${DAY} {
    public int doStuff(int[] indices) {
        return 0;
    }
}
__IMPL__

cat <<__TEST__ > src/test/java/aoc2017/Day${DAY}Test.java
package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static aoc2017.Utils.*;

@DisplayName("Day ${DAY}")
class Day${DAY}Test {
    private Day${DAY} day = new Day${DAY}();

    @BeforeEach
    public void setUp() {
        day = new Day${DAY}();
    }

    @Test
    public void testPart1() throws IOException {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(0));
    }

    @Test
    public void solvePart1() throws IOException {
        int[] input = TestUtil.readResourceAsInts("/day${DAY}.txt");
        assertThat(day.doStuff(input), is(0));
    }

    @Test
    public void testPart2() throws IOException {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(0));
    }

    @Test
    public void solvePart2() throws IOException {
        int[] input = TestUtil.readResourceAsInts("/day${DAY}.txt");
        assertThat(day.doStuff(input), is(0));
    }
}
__TEST__


