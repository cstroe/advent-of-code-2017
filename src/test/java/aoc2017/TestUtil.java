package aoc2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class TestUtil {
    public static List<String> readResource(String path) throws IOException {
        InputStream is = TestUtil.class.getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        List<String> lines = new LinkedList<>();
        while((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    public static int[] readResourceAsInts(String path) throws IOException {
        return readResource(path).stream().mapToInt(Integer::parseInt).toArray();
    }
}
