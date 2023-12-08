import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[] pillars = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //기둥 갯수

        int lo = Integer.MAX_VALUE; // 기둥 중 맨 왼쪽
        int hi = 0; // 기둥 중 맨 오른쪽
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            pillars[L] = H;
            lo = Math.min(L, lo);
            hi = Math.max(L, hi);
        }

        Stack<Integer> S = new Stack<>();

        // 왼쪽에서 출발
        int tmp = pillars[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (tmp > pillars[i]) {
                S.push(i);
            } else {
                while (!S.isEmpty()) {
                    int x = S.pop();
                    pillars[x] = tmp;
                }
                tmp = pillars[i];
            }
        }
        S.clear();

        // 오른쪽에서 출발
        tmp = pillars[hi];
        for (int i = hi - 1; i >= lo; i--) {
            if (pillars[i] < tmp) {
                S.push(i);
            } else {
                while (!S.isEmpty()) {
                    int x = S.pop();
                    pillars[x] = tmp;
                }
                tmp = pillars[i];
            }
        }

        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            sum += pillars[i];
        }
        System.out.println(sum);
    }
}