import java.util.*;

public class Main {
    static int Q, N;

    static List<Integer> indexs;
    static List<List<Integer>> mountains;
    
    public static void main(String[] args) throws Exception {
        Q = read();

        while (Q-- > 0) {
            int cmd = read();
            switch (cmd) {
                case 100: {
                    N = read();
                    indexs = new ArrayList<>();
                    mountains = new ArrayList<>();
                    for (int i = 0; i < N; i++) {
                        int height = read();
                        int idx = binarySearch(height);
                        indexs.add(idx);
                        if (idx == mountains.size()) mountains.add(new ArrayList<>());
                        mountains.get(idx).add(height);
                    }
                    break;
                }

                // 산 추가
                case 200: {
                    int height = read();
                    int idx = binarySearch(height);
                    indexs.add(idx);
                    if (idx == mountains.size()) mountains.add(new ArrayList<>());
                    mountains.get(idx).add(height);
                    break;
                }

                // 산 삭제
                case 300: {
                    int idx = indexs.get(indexs.size() - 1);
                    indexs.remove(idx);
                    if (mountains.get(mountains.size() - 1).size() == 0) mountains.remove(mountains.size() - 1);
                    break;
                }

                // 등산 시뮬레이션
                case 400: {
                    int ci = read(); // 케이블카 인덱스
                    ci--;
                    System.out.println((indexs.get(ci) + mountains.size()) * 1000000 + mountains.get(mountains.size() - 1).get(0));

                    // for (int i : indexs) {
                    //     System.out.print(i + " ");
                    // }
                    // System.out.println();

                    // for (List<Integer> list : mountains) {
                    //     for (int i : list) {
                    //         System.out.print(i + " ");
                    //     }
                    //     System.out.println();
                    // }
                    // System.out.println();
                    break;
                }
            }
        }
    }

    private static int binarySearch(int height) {
        if (mountains.size() == 0) return 0;
        int l = 0, r = mountains.size() - 1, m;
        int idx = mountains.size();
        while (l <= r) {
            m = (l + r) / 2;
            List<Integer> tmp = mountains.get(m);
            if (tmp.get(tmp.size() - 1) >= height) {
                idx = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return idx;
    }

    private static int findScore(int l, int r) {
        return 1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}