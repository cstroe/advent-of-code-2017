package aoc2017;

import static aoc2017.Day001.score;

/**
 * Read {@link Day001} for Part One.
 *
 * --- Part Two ---

 You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:

 Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.

 For example:

 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
 1221 produces 0, because every comparison is between a 1 and a 2.
 123425 produces 4, because both 2s match each other, but no other digit has a match.
 123123 produces 12.
 12131415 produces 4.

 What is the solution to your new captcha?
 */
public class Day002 {
    public long getSum(String digits) {
        if(digits == null || digits.isEmpty()) {
            return 0;
        }

        if(digits.length() % 2 != 0) {
            throw new IllegalArgumentException("Only accepts an even number of digits.");
        }

        byte[] bytes = digits.getBytes();

        int upperIndex = digits.length() / 2;
        long sum = 0;
        for(int i = 0; i < bytes.length; i++) {
            if(bytes[i] == bytes[upperIndex]) {
                sum += score(bytes[i]);
            }

            upperIndex = advanceIndex(upperIndex, bytes.length);
        }
        return sum;
    }

    private int advanceIndex(int index, int numDigits) {
        int nextIndex = index + 1;
        if(nextIndex == numDigits) {
            return 0;
        }
        return nextIndex;
    }
}
