package aoc2017;

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
}
