import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> D = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            D.addLast(i);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (D.peekFirst() != n) {
                int idx = 0;
                for (Integer e : D) {
                    idx++;
                    if(e == n)
                        break;
                }
                int l = idx - 1;
                int r = D.size() - idx + 1;
                if (l < r) {
                    left(D, l);
                    count += l;
                }
                else {
                    right(D, r);
                    count += r;
                }
            }

            if (D.peekFirst() == n) {
                D.removeFirst();
            }

        }

        System.out.println(count);
    }

    private static void poll(Deque D) {
        D.removeFirst();
    }

    private static void left(Deque D, int n) {
        for (int i = 0; i < n; i++)
            D.offerLast(D.pollFirst());
    }

    private static void right(Deque D, int n) {
        for (int i = 0; i < n; i++)
            D.offerFirst(D.pollLast());
    }

}