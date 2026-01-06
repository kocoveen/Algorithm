import java.io.*;
import java.util.*;

public class Main {
    static String[] line;
    
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        // <문제번호, 문제> Map
        TreeMap<Integer, Problem> map = new TreeMap<>();
        
        // <분류, 문제> Map
        TreeMap<Integer, TreeSet<Problem>> groupMap = new TreeMap<>();

        // <난이도, 문제번호> Map
        NavigableMap<Integer, TreeSet<Integer>> levelMap = new TreeMap<>();

        line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        while (N-- > 0) {
            line = reader.readLine().split(" ");
            int P = Integer.parseInt(line[0]);
            int L = Integer.parseInt(line[1]);
            int G = Integer.parseInt(line[2]);

            Problem p = new Problem(P, L, G);
            map.put(P, p); // 문제번호
            levelMap.computeIfAbsent(L, levelKey -> new TreeSet<>()).add(P);
            groupMap.computeIfAbsent(G, groupKey -> new TreeSet<>()).add(p);
        }

        line = reader.readLine().split(" ");
        int M = Integer.parseInt(line[0]);

        while (M-- > 0) {
            line = reader.readLine().split(" ");
            String cmd = line[0];
            Integer problem = switch (cmd) {
                case "add": {
                    int P = Integer.parseInt(line[1]);
                    int L = Integer.parseInt(line[2]);
                    int G = Integer.parseInt(line[3]);

                    Problem p = new Problem(P, L, G);
                    map.put(P, p); // 문제번호
                    levelMap.computeIfAbsent(L, levelKey -> new TreeSet<>()).add(P);
                    groupMap.computeIfAbsent(G, groupKey -> new TreeSet<>()).add(p);
                    yield 0;
                }

                case "recommend": {
                    int G = Integer.parseInt(line[1]);
                    int x = Integer.parseInt(line[2]);

                    yield x == 1 ? groupMap.get(G).last().number : groupMap.get(G).first().number;
                }

                case "recommend2": {
                    int x = Integer.parseInt(line[1]);
                    yield x == 1 
                        ? levelMap.get(levelMap.lastKey()).last() 
                        : levelMap.get(levelMap.firstKey()).first();
                }

                case "recommend3": {
                    int x = Integer.parseInt(line[1]);
                    int L = Integer.parseInt(line[2]);
                    yield x == 1 
                        ? levelMap.ceilingKey(L) != null ? levelMap.get(levelMap.ceilingKey(L)).first() : -1
                        : levelMap.lowerKey(L) != null ? levelMap.get(levelMap.lowerKey(L)).last() : -1;
                }

                case "solved": {
                    int P = Integer.parseInt(line[1]);
                    Problem p = map.remove(P);

                    groupMap.get(p.group).remove(p);
                    if (groupMap.get(p.group).isEmpty()) {
                        groupMap.remove(p.group);
                    }

                    levelMap.get(p.level).remove(p.number);
                    if (levelMap.get(p.level).isEmpty()) {
                        levelMap.remove(p.level);
                    }

                    yield 0;
                }

                default: {
                    yield 0;
                }
            };

            if (problem != 0) { System.out.println(problem); } else {}
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    private static class Problem implements Comparable<Problem> {
        int number;
        int level;
        int group;

        public Problem(int number, int level, int group) {
            this.number = number;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level) {
                return this.number - o.number;
            }
            return this.level - o.level;
        }
        
    }
}