import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static class Info {
        int v, i;
        public Info(int v, int i) {
            this.v = v;
            this.i = i;
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = read(); int l = read();
        Deque<Info> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int v = read();
            while (!dq.isEmpty() && dq.peekLast().v > v) dq.pollLast();
            dq.offerLast(new Info(v, i));
            if (dq.getFirst().i <= i - l) dq.pollFirst();
            sb.append(dq.getFirst().v).append(" ");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}