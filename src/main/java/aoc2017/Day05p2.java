package aoc2017;

/**
 * --- Part Two ---

 Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.

 Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.

 How many steps does it now take to reach the exit?

 */
public class Day05p2 {
    public int doStuff(int[] indices) {
        int currentPosition = 0;
        int jumps = 0;
        try {
            while(true) {
                int currentJump = indices[currentPosition];
                if(currentJump >= 3) {
                    indices[currentPosition]--;
                } else {
                    indices[currentPosition]++;
                }
                jumps++;
                currentPosition = currentPosition + currentJump;
            }
        } catch(Exception ex) {
            // gulp
        }
        return jumps;
    }
}
