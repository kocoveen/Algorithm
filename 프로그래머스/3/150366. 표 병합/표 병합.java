import java.util.*;

class Solution {
    Point[][] parent = new Point[50][50];
    String[][] table = new String[50][50];

    public String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                parent[i][j] = new Point(i, j);
            }
        }

        for (String command : commands) {
            String[] query = command.split(" ");
            String cmd = query[0];

            switch (cmd) {
                case "UPDATE" -> {
                    if (query.length == 4) {
                        int r = Integer.parseInt(query[1]) - 1;
                        int c = Integer.parseInt(query[2]) - 1;
                        Point root = find(new Point(r, c));
                        table[root.r()][root.c()] = query[3];
                    } else {
                        String v1 = query[1];
                        String v2 = query[2];
                        for (int i = 0; i < 50; i++) {
                            for (int j = 0; j < 50; j++) {
                                if (v1.equals(table[i][j])) {
                                    table[i][j] = v2;
                                }
                            }
                        }
                    }
                }
                case "MERGE" -> {
                    int r1 = Integer.parseInt(query[1]) - 1;
                    int c1 = Integer.parseInt(query[2]) - 1;
                    int r2 = Integer.parseInt(query[3]) - 1;
                    int c2 = Integer.parseInt(query[4]) - 1;

                    Point root1 = find(new Point(r1, c1));
                    Point root2 = find(new Point(r2, c2));

                    if (root1.equals(root2)) continue;

                    String v1 = table[root1.r()][root1.c()];
                    String v2 = table[root2.r()][root2.c()];
                    String mergedValue = (v1 != null) ? v1 : v2;

                    table[root1.r()][root1.c()] = null;
                    table[root2.r()][root2.c()] = null;

                    // root2를 root1 밑으로 병합
                    parent[root2.r()][root2.c()] = root1;
                    table[root1.r()][root1.c()] = mergedValue;
                }
                case "UNMERGE" -> {
                    int r = Integer.parseInt(query[1]) - 1;
                    int c = Integer.parseInt(query[2]) - 1;
                    Point target = new Point(r, c);
                    Point root = find(target);
                    String rootValue = table[root.r()][root.c()];

                    // 같은 그룹에 속한 모든 Point 수집
                    List<Point> group = new ArrayList<>();
                    for (int i = 0; i < 50; i++) {
                        for (int j = 0; j < 50; j++) {
                            if (find(new Point(i, j)).equals(root)) {
                                group.add(new Point(i, j));
                            }
                        }
                    }

                    // 그룹 초기화 및 target 셀에만 값 복원
                    for (Point p : group) {
                        parent[p.r()][p.c()] = p;
                        table[p.r()][p.c()] = null;
                    }
                    table[r][c] = rootValue;
                }
                case "PRINT" -> {
                    int r = Integer.parseInt(query[1]) - 1;
                    int c = Integer.parseInt(query[2]) - 1;
                    Point root = find(new Point(r, c));
                    String val = table[root.r()][root.c()];
                    result.add(val == null ? "EMPTY" : val);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    private Point find(Point p) {
        Point currParent = parent[p.r()][p.c()];
        if (p.equals(currParent)) {
            return p;
        }
        return parent[p.r()][p.c()] = find(currParent);
    }
}

record Point(int r, int c) {}
