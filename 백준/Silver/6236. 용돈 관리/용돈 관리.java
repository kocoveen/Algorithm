import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, M, mx;
    static int[] amounts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        amounts = new int[N];
        for (int i = 0; i < N; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, amounts[i]);
        }

        int result = binarySearch();
        System.out.println(result);
    }

    private static int binarySearch() {
        int l = mx, r = 1000000000, m;
        while (l < r) {
            m = (l + r) / 2;
            if (M < getCount(m)) l = m + 1;
            else r = m;
        }
        return l;
    }

    private static int getCount(int withdrawal) {
        int money = 0, count = 0;
        for (int amount : amounts) {
            money -= amount;
            if (money < 0) {
                count++;
                money = withdrawal - amount;
            }
        }
        return count;
    }
}