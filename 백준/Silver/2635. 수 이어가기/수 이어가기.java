import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> numbers = new ArrayList<>();
    static int mxSize, n2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫 수

        numbers.add(n);
        int prev2 = n;
        for (int prev1 = n / 2; prev1 <= n; prev1++) {
            numbers.add(prev1);
            backtracking(prev2, prev1, 1);
            numbers.remove(1);
        }

        numbers.clear();
        numbers.add(n);
        numbers.add(n2);
        while (numbers.get(numbers.size() - 2) >= numbers.get(numbers.size() - 1)) {
            numbers.add(numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1));
        }

        System.out.println(mxSize);
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }

    private static void backtracking(int prev2, int prev1, int depth) { //
        if (prev2 < prev1) {
            if (mxSize < depth + 1) {
                mxSize = depth + 1;
                n2 = numbers.get(1);
            }
            return;
        }

        int cur = prev2 - prev1;
        numbers.add(cur);
        backtracking(prev1, cur, depth + 1);
        numbers.remove(depth + 1);
    }
}