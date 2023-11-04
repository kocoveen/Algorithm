import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        bfs(a, b);
    }

    private static void bfs(long a, long b) {
        Deque<Pair> dq = new LinkedList<>();
        dq.offerLast(new Pair(a, 1));

        while (!dq.isEmpty()) {
            Pair cur = dq.pollFirst();

            for (long nxt : new long[]{cur.num * 2, Long.parseLong(cur.num + "1")}) {
                if (nxt == b) {
                    System.out.println(cur.count + 1);
                    System.exit(0);
                } else if (nxt < b) {
                    dq.offerLast(new Pair(nxt, cur.count + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static class Pair {
        long num, count;

        public Pair(long num, long count) {
            this.num = num;
            this.count = count;
        }
    }
}