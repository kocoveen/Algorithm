import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] grows = new int[n];
        Pair[] trees = new Pair[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < n; i++) grows[i] = sc.nextInt();
        for (int i = 0; i < n; i++) trees[i] = new Pair(nums[i], grows[i]);

        Arrays.sort(trees, (t1, t2) -> t1.grow - t2.grow);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += trees[i].num + (long) trees[i].grow * i;
        }
        System.out.println(sum);
    }

    static class Pair {
        private int num;
        private int grow;

        Pair(int num, int grow) {
            this.num = num;
            this.grow = grow;
        }
    }
}
