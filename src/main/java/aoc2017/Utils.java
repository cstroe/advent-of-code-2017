package aoc2017;

import java.util.Arrays;

public class Utils {
    public static int findMaxIndex(int[] values) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < values.length; i++) {

            if(values[i] > maxValue) {
                maxIndex = i;
                maxValue = values[i];
            }
        }

        return maxIndex;
    }

    public static int findIndexOf(int[] values, int value) {
        for(int i = 0; i < values.length; i++) {
            if(values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int min(int[] values) {
        return Arrays.stream(values).min().getAsInt();
    }

    public static int max(int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }

    public static int count(int[] values, int value) {
        int i = 0;
        for(int v : values) {
            if(v == value) {
                i++;
            }
        }
        return i;
    }
}
