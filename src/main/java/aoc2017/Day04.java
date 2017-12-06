package aoc2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * --- Day 4: High-Entropy Passphrases ---

 A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

 To ensure security, a valid passphrase must contain no duplicate words.

 For example:

 aa bb cc dd ee is valid.
 aa bb cc dd aa is not valid - the word aa appears more than once.
 aa bb cc dd aaa is valid - aa and aaa count as different words.

 The system's full passphrase list is available as your puzzle input. How many passphrases are valid?

 */

/*
      --------Part 1--------   --------Part 2--------
Day       Time   Rank  Score       Time   Rank  Score
  4   01:29:04   2341      0   01:39:15   2137      0
 */
public class Day04 {
    public int countValidPasswords(List<String> passwords) {
        return passwords.stream().mapToInt(this::isValid).sum();
    }

    private int isValid(String password) {
        String[] words = password.split("\\s");
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(words));

        if(words.length != set.size()) {
            return 0;
        }
        return 1;
    }

    public int countValidPasswords2(List<String> passwords) {
        return passwords.stream().mapToInt(this::isValid2).sum();
    }

    private int isValid2(String password) {
        String[] words = password.split("\\s");

        String[] normalized = normalize(words);

        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(normalized));

        if(words.length != set.size()) {
            return 0;
        }
        return 1;
    }

    private String[] normalize(String[] words) {
        String[] n = new String[words.length];

        for(int i = 0; i < words.length; i++) {
            String curr = words[i];
            char[] chars = curr.toCharArray();
            Arrays.sort(chars);
            n[i] = new String(chars);
        }

        return n;
    }
}
