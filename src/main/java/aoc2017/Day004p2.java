package aoc2017;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day004p2 {
    public int countValidPasswords(List<String> passwords) {
        return passwords.stream().mapToInt(this::isValid).sum();
    }

    private int isValid(String password) {
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
