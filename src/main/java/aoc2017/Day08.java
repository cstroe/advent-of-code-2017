package aoc2017;

import java.util.*;
import java.util.stream.Collectors;

import static aoc2017.Utils.*;

/*
      --------Part 1--------   --------Part 2--------
Day       Time   Rank  Score       Time   Rank  Score
  8   00:15:12    482      0   00:18:45    531      0
 */
public class Day08 {
    int maxEver = Integer.MIN_VALUE;
    Map<String, Integer> registers = new HashMap<>();

    public int part1(List<String> instructions) {

        for(String instr : instructions) {
            String[] stuff = instr.split("\\s");

            String compareTo = stuff[4];
            Integer compareVal = registers.getOrDefault(compareTo, 0);
            Integer compareVal2 = Integer.parseInt(stuff[6]);
            switch (stuff[5]) {
                case ">":
                    if(compareVal > compareVal2) {
                        doAction(stuff[1], stuff[0], Integer.parseInt(stuff[2]));
                    }
                    break;
                case "<":
                    if(compareVal < compareVal2) {
                        doAction(stuff[1], stuff[0], Integer.parseInt(stuff[2]));
                    }
                    break;
                case ">=":
                    if(compareVal >= compareVal2) {
                        doAction(stuff[1], stuff[0], Integer.parseInt(stuff[2]));
                    }
                    break;
                case "==":
                    if(compareVal.intValue() == compareVal2.intValue()) {
                        doAction(stuff[1], stuff[0], Integer.parseInt(stuff[2]));
                    }
                    break;
                case "<=":
                    if(compareVal <= compareVal2) {
                        doAction(stuff[1], stuff[0] , Integer.parseInt(stuff[2]));
                    }
                    break;
                case "!=":
                    if(compareVal.intValue() != compareVal2.intValue()) {
                        doAction(stuff[1], stuff[0], Integer.parseInt(stuff[2]));
                    }
                    break;
            }
        }

        return registers.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    }

    public int part2(List<String> instructions) {
        part1(instructions);
        return maxEver;
    }

    private void doAction(String action, String registerName, Integer value) {
        Integer current = registers.get(registerName) == null ? 0 : registers.get(registerName);
        if ("inc".equals(action)) {
            int newVal = current + value;
            maxEver = Math.max(newVal, maxEver);
            registers.put(registerName, newVal);
        } else if("dec".equals(action)) {
            int newVal = current - value;
            maxEver = Math.max(newVal, maxEver);
            registers.put(registerName, newVal);
        } else {
            throw new IllegalArgumentException("no such action " + action);
        }
    }
}