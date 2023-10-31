import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static Integer[] time = new Integer[100001];
    static int n, k;
    static Integer minTime;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);

        Deque<Integer> d = new LinkedList<>();
        d.offerLast(n);
        time[n] = 0;
        
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }
        
        while (!d.isEmpty()) {
            int cur = d.pollFirst();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = cur - 1;
                } else if (i == 1) {
                    nx = cur + 1;
                } else {
                    nx = cur * 2;
                }

                if (nx < 0 || nx > 100000) continue;
                if (time[nx] == null) {
                    time[nx] = time[cur] + 1;
                    if (nx == k) {
                        minTime = time[cur] + 1;
                        count++;
                        continue;
                    }
                } else {
                    if (time[nx] < time[cur] + 1) {
                        continue;
                    } else if (nx == k) {
                        minTime = time[cur] + 1;
                        count++;
                        continue;
                    }
                }

                d.offerLast(nx);
                time[nx] = time[cur] + 1;
            }
        }
        System.out.println(minTime);
        System.out.println(count);
    }
}