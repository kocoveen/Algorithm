import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Long> pq;
    static String[] line;
    static int t, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            pq = new PriorityQueue<>();
            k = Integer.parseInt(br.readLine());
            line = br.readLine().split(" ");
            while (k-- > 0) {
                pq.add(Long.valueOf(line[k]));
            }

            long total = 0;
            while (pq.size() != 1) {
                long f = pq.remove();
                long s = pq.remove();
                long sum = f + s;
                total += sum;
                pq.add(sum);
            }
            sb.append(total).append('\n');
        }
        System.out.print(sb);
    }
}
