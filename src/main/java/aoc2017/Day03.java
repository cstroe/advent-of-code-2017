package aoc2017;

import java.util.HashMap;
import java.util.Map;

import static aoc2017.Day03.Direction.*;

/**
 * --- Day 3: Spiral Memory ---

 You come across an experimental new kind of memory stored on an infinite two-dimensional grid.

 Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while spiraling outward. For example, the first few squares are allocated like this:

 17  16  15  14  13
 18   5   4   3  12
 19   6   1   2  11
 20   7   8   9  10
 21  22  23---> ...

 While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1 (the location of the only access port for this memory system) by programs that can only move up, down, left, or right. They always take the shortest path: the Manhattan Distance between the location of the data and square 1.

 For example:

 Data from square 1 is carried 0 maxSteps, since it's at the access port.
 Data from square 12 is carried 3 maxSteps, such as: down, left, left.
 Data from square 23 is carried only 2 maxSteps: up twice.
 Data from square 1024 must be carried 31 maxSteps.

 How many maxSteps are required to carry the data from the square identified in your puzzle input all the way to the access port?

 Your puzzle input is 347991.
 */
/*
      --------Part 1--------   --------Part 2--------
Day       Time   Rank  Score       Time   Rank  Score
  3   05:36:07   3485      0       >24h   8131      0
 */
public class Day03 {
    public static class Ring {
        long num = 1;
        long base = 1;

        public Ring() {}

        public Ring(long num, long base) {
            this.num = num;
            this.base = base;
        }

        public long max() {
            return base * base;
        }

        public void grow() {
            num++;
            base += 2;
        }

        public long maxSteps() {
            if(num == 1) {
                return 0;
            }
            return (num - 1) * 2;
        }

        public long minSteps() {
            if(num == 1) {
                return 0;
            }

            return num - 1;
        }
    }

    public long computeSteps(long port) {
        if(port == 1) {
            return 0;
        }

        Ring ring = findRing(port);

        long steps = ring.maxSteps();
        long dir = -1;
        for(long cp = ring.max(); cp > port; cp--) {
            if(dir < 0) {
                steps--;
                if(steps == ring.minSteps()) {
                    dir = 1;
                }
            } else {
                steps++;
                if(steps == ring.maxSteps()) {
                    dir = -1;
                }
            }
        }
        return steps;
    }

    Ring findRing(long port) {
        Ring ring = new Ring();
        while(port > (ring.max())) {
            ring.grow();
        }
        return ring;
    }

    /**
     * --- Part Two ---

     As a stress test on the system, the programs here clear the grid and then store the value 1 in square 1. Then, in the same allocation order as shown above, they store the sum of the values in all adjacent squares, including diagonals.

     So, the first few squares' values are chosen as follows:

     Square 1 starts with the value 1.
     Square 2 has only one adjacent filled square (with value 1), so it also stores 1.
     Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.
     Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their values, 4.
     Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.

     Once a square is written, its value does not change. Therefore, the first few squares would receive the following values:

     147  142  133  122   59
     304    5    4    2   57
     330   10    1    1   54
     351   11   23   25   26
     362  747  806--->   ...

     What is the first value written that is larger than your puzzle input?

     Your puzzle input is still 347991.
     */
    public long computePart2(long input) {
        return 0;
    }

    public enum Direction { N, S, W, E, NE, NW, SE, SW }

    public static class Cell {
        public final long value;
        private Direction nextDirection = E;
        private Map<Direction, Cell> surroundingCells = new HashMap<>();

        public static Cell firstCell() {
            return new Cell(1);
        }

        private Cell(long value) {
            this.value = value;
        }

        public Cell next() {
            if(nextDirection == E) {
                /*
                ....
                ....
                .TN.
                ....
                 */

                Cell thisNorth = surroundingCells.get(N);
                Cell thisNorthEast = surroundingCells.get(NE);
                Cell thisNorthEastEast = thisNorthEast == null ? null : thisNorthEast.surroundingCells.get(E);

                Cell newCell = new Cell(value + value(thisNorth) + value(thisNorthEast) + value(thisNorthEastEast));
                surroundingCells.put(E, newCell);
                newCell.surroundingCells.put(W, this);
                newCell.surroundingCells.put(NW, thisNorth);
                newCell.surroundingCells.put(N, thisNorthEast);
                newCell.surroundingCells.put(NE, thisNorthEastEast);

                if(newCell.surroundingCells.get(N) == null) {
                    newCell.nextDirection = N;
                } else {
                    newCell.nextDirection = nextDirection;
                }

                return newCell;
            }

            if(nextDirection == N) {
                /*
                ....
                ..N.
                ..T.
                ....
                 */

                Cell thisWest = surroundingCells.get(W);
                Cell thisNorthWest = surroundingCells.get(NW);
                Cell thisNorthWestNorth = thisNorthWest == null ? null : thisNorthWest.surroundingCells.get(N);

                Cell newCell = new Cell(value + value(thisWest) + value(thisNorthWest) + value(thisNorthWestNorth));
                surroundingCells.put(N, newCell);
                newCell.surroundingCells.put(S, this);
                newCell.surroundingCells.put(SW, thisWest);
                newCell.surroundingCells.put(W, thisNorthWest);
                newCell.surroundingCells.put(NW, thisNorthWestNorth);

                if(newCell.surroundingCells.get(W) == null) {
                    newCell.nextDirection = W;
                } else {
                    newCell.nextDirection = nextDirection;
                }

                return newCell;
            }

            if(nextDirection == W) {
                /*
                ....
                .NT.
                ....
                */
                Cell thisSouth = surroundingCells.get(S);
                Cell thisSouthWest = surroundingCells.get(SW);
                Cell thisSouthWestWest = thisSouthWest == null ? null : thisSouthWest.surroundingCells.get(W);

                Cell newCell = new Cell(value + value(thisSouth) + value(thisSouthWest) + value(thisSouthWestWest));
                surroundingCells.put(W, newCell);
                newCell.surroundingCells.put(E, this);
                newCell.surroundingCells.put(SE, thisSouth);
                newCell.surroundingCells.put(S, thisSouthWest);
                newCell.surroundingCells.put(SW, thisSouthWestWest);

                if(newCell.surroundingCells.get(S) == null) {
                    newCell.nextDirection = S;
                } else {
                    newCell.nextDirection = nextDirection;
                }

                return newCell;
            }

            if(nextDirection == S) {
                /*
                ....
                .T.
                .N..
                ....
                */
                Cell thisEast = surroundingCells.get(E);
                Cell thisSouthEast = surroundingCells.get(SE);
                Cell thisSouthEastSouth = thisSouthEast == null ? null : thisSouthEast.surroundingCells.get(S);

                Cell newCell = new Cell(value + value(thisEast) + value(thisSouthEast) + value(thisSouthEastSouth));
                surroundingCells.put(S, newCell);
                newCell.surroundingCells.put(N, this);
                newCell.surroundingCells.put(NE, thisEast);
                newCell.surroundingCells.put(E, thisSouthEast);
                newCell.surroundingCells.put(SE, thisSouthEastSouth);

                if(newCell.surroundingCells.get(E) == null) {
                    newCell.nextDirection = E;
                } else {
                    newCell.nextDirection = nextDirection;
                }

                return newCell;
            }

            throw new RuntimeException();
        }

        @Override
        public String toString() {
            return "Cell{ value=" + value + ", nextDirection=" + nextDirection.name() + " }";
        }

        private long value(Cell cell) {
            if(cell == null) {
                return 0;
            }

            return cell.value;
        }
    }
}
