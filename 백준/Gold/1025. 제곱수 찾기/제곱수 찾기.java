import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static int n, m;
    static char[][] A;
    static Set<Integer> set = new HashSet<>();
    static TreeSet<Integer> nums = new TreeSet<>(Comparator.comparingInt(Integer::intValue).reversed());
    // static char[] num = new char[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        // 1. 입력 받기
        n = Integer.parseInt(NM[0]); m = Integer.parseInt(NM[1]);
        A = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = line.charAt(j);
            }
        }

        // 2. 완전제곱수 집합 만들기
        for (int i = 0; i < 32000; i++) {
            set.add(i * i);
        }

        for (int r0 = 0; r0 < n; r0++) {
            for (int c0 = 0; c0 < m; c0++) {
                char[] numChar = new char[10];

                for (int rx = -n + 1; rx < n; rx++) {
                    for (int ry = -m + 1; ry < m; ry++) {

                        // 0, 0 이면 mux를 곱할 필요가 없어, 따로 처리
                        if (rx == 0 && ry == 0) {
                            numChar[0] = A[r0][c0];
                            int num = getInteger(numChar, 0);
                            nums.add(num);
                            continue;
                        }

                        for (int mux = 0; mux < 10; mux++) {
                            int r = r0 + rx * mux;
                            int c = c0 + ry * mux;
                            if (r < 0 || r >= n || c < 0 || c >= m) continue;

                            numChar[mux] = A[r][c];
                            int num = getInteger(numChar, mux);
                            int num2 = getReversedInteger(numChar, mux);

                            nums.add(num);
                            nums.add(num2);

                        }

                    }
                }
            }
        }

        // 3. 완전제곱수 찾기
        for (int num : nums) {
            if (set.contains(num)) {
                System.out.println(num);
                return;
            }
        }
        System.out.println(-1);
    }

    static int getInteger(char[] num, int last) {
        return Integer.parseInt(String.valueOf(num, 0, last + 1));
    }

    static int getReversedInteger(char[] num, int last) {
        StringBuilder sb = new StringBuilder();
        sb.append(num, 0, last + 1).reverse();
        return Integer.parseInt(sb.toString());
    }
}