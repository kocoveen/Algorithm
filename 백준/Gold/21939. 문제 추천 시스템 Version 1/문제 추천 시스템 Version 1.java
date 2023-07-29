import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] tokens;
    static int n, p, l, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // tm<lv, tm<pid, lv>>
        TreeMap<Integer, TreeMap<Integer, Integer>> problemMap = new TreeMap<>();
        Map<Integer, Integer> problems = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            tokens = br.readLine().split(" ");
            p = Integer.parseInt(tokens[0]);
            l = Integer.parseInt(tokens[1]);
            problemMap.computeIfAbsent(l, l -> new TreeMap<>()).put(p, l);
            problems.put(p, l);

        }

        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            tokens = br.readLine().split(" ");
            switch (tokens[0]) {
                case "add": {
                    p = Integer.parseInt(tokens[1]);
                    l = Integer.parseInt(tokens[2]);
                    problemMap.computeIfAbsent(l, l -> new TreeMap<>()).put(p, l);
                    problems.put(p, l);
                    break;
                }
                case "solved": {
                    p = Integer.parseInt(tokens[1]);
                    l = problems.get(p);
                    problemMap.get(l).remove(p);
                    if (problemMap.get(l).size() == 0) {
                        problemMap.remove(l);
                    }
                    problems.remove(p);
                    break;
                }
                case "recommend": {
                    int x = Integer.parseInt(tokens[1]);
                    if (x == 1) {
                        p = problemMap.get(problemMap.lastKey()).lastKey();
                    } else {
                        p = problemMap.get(problemMap.firstKey()).firstKey();
                    }
                    sb.append(p).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}