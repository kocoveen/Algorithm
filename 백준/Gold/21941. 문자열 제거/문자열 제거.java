
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static String S;
    static List<Node> words = new ArrayList<>();
    static Integer[] dp;

    static class Node {
        String word;
        int score;
        Node(String word, int score) {
            this.word = word;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        N = S.length();
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String word = sc.next();
            int score = sc.nextInt();

            if (score > word.length()) {
                words.add(new Node(word, score));
            }
        }

        dp = new Integer[S.length()];

        System.out.print(dp(0));
    }

    private static int dp(int i) {
        if (i >= N) return 0;
        if (dp[i] != null) return dp[i];

        int result = dp(i + 1) + 1;

        for (Node node : words) {
            if (S.startsWith(node.word, i)) {
                result = Math.max(result, node.score + dp(i + node.word.length()));
            }
        }
        return dp[i] = result;
    }
}