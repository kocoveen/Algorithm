import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int mx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> balls = new ArrayList<>();
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            balls.add(Integer.valueOf(split[i]));
        }

        backtracking(balls, 0);
        System.out.println(mx);
    }

    static void backtracking(List<Integer> balls, int sum) {
        if (balls.size() == 2) {
            mx = Math.max(sum, mx);
            return;
        }

        for (int i = 1; i < balls.size() - 1; i++) {
            int energy = balls.get(i - 1) * balls.get(i + 1);
            Integer removed = balls.remove(i);
            backtracking(balls, sum + energy);
            balls.add(i, removed);
        }

    }
}