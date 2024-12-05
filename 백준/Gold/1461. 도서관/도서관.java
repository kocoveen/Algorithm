import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int ans = 0;

        Comparator<Integer> comparator = (i1, i2) -> i2 - i1;

        PriorityQueue<Integer> positives = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> negatives = new PriorityQueue<>(comparator);

        for (int i = 0; i < N; i++) {
            int x = read();
            if (x > 0) positives.add(x);
            if (x < 0) negatives.add(-x);
        }

        if (positives.isEmpty()) positives.add(0);
        if (negatives.isEmpty()) negatives.add(0);

        int max = Math.max(positives.peek(), negatives.peek());

        int i = 0;
        while (!positives.isEmpty()) {
            int poll = positives.poll();
            if (i++ % M == 0) { ans += poll * 2; }
        }

        int j = 0;
        while (!negatives.isEmpty()) {
            int poll = negatives.poll();
            if (j++ % M == 0)  { ans += poll * 2; }
        }

        ans -= max;
        System.out.println(ans);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) { n = System.in.read() & 15; }
        while ((c = System.in.read()) > 32) { n = (n << 3) + (n << 1) + (c & 15); }
        return isNegative ? ~n + 1 : n;
    }
}