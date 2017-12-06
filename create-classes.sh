#!/usr/bin/env bash

#set -x

if [ -z "$1" ]; then
  echo "Usage: $0 <day>"
  echo "Example: $0 5"
  exit 1
fi

DAY=`printf "%02d" $1`

create_files () {

cat <<__IMPL__ > src/main/java/aoc2017/Day${DAY}p$1.java
package aoc2017;

public class Day${DAY}p$1 {
    public int doStuff(int[] indices) {
        return 0;
    }
}
__IMPL__

cat <<__TEST__ > src/test/java/aoc2017/Day${DAY}p${1}Test.java
package aoc2017;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Day ${DAY} - Part $1")
class Day${DAY}p${1}Test {
    private Day${DAY}p$1 day = new Day${DAY}p$1();

    @Test
    public void simpleTest() {
        int[] testInput = new int[] {0, 3, 0, 1, -3};
        assertThat(day.doStuff(testInput), is(0));
    }

    @Test
    public void solveProblem() throws IOException {
        int[] input = TestUtil.readResourceAsInts("/day${DAY}.txt");
        assertThat(day.doStuff(input), is(0));
    }
}
__TEST__

}

create_files 1
create_files 2


