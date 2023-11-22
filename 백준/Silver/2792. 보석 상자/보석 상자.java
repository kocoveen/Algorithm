import java.io.*;

public class Main {

    static String[] st;
    static int[] jewels;
    static int mx; // 최대 보석 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]); // 학생 수
        int m = Integer.parseInt(st[1]); // 보석 수

        jewels = new int[m];
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, jewels[i]);
        }

        // index -> 나누려는 보석 수, findDistributedNum(m) -> 가질 수 있는 사람 수
        int index = binarySearch(n); //lower bound
        System.out.println(index);
    }

    private static int binarySearch(int n) { //lower bound
        int l = 1, r = mx + 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (findDistributedNum(m) <= n) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static int findDistributedNum(int m) {
        int div = 0;
        for (int jewel : jewels) {
            div += jewel / m + (jewel % m != 0 ? 1 : 0);
        }
        return div;
    }
}