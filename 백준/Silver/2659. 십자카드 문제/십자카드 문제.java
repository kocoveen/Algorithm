import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] tmp = new int[4];
    static Set<Integer> set = new HashSet<>();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[4];
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        nums[2] = Integer.parseInt(st.nextToken());
        nums[3] = Integer.parseInt(st.nextToken());

        int clockNumber = getClockNumber(nums);
        dfs(0, clockNumber);
    }

    private static void dfs(int depth, int clockNumber) {
        if (depth == 4) {
            int cn = getClockNumber(tmp);
            if (!set.contains(cn)) {
                count++;
                set.add(cn);
            }

            if (clockNumber == cn) {
                System.out.println(count);
                System.exit(0);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            tmp[depth] = i;
            dfs(depth + 1, clockNumber);
        }
    }

    private static int getClockNumber(int[] nums) {
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            mn = Math.min(mn, getNumber(nums, i));
        }
        return mn;
    }

    private static int getNumber(int[] nums, int i) {
        return nums[i] * 1000 +
                nums[(i + 1) % 4] * 100 +
                nums[(i + 2) % 4] * 10 +
                nums[(i + 3) % 4];
    }
}