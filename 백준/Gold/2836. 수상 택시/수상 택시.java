import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static long n, m, result;
    static PriorityQueue<Customer> customers = new PriorityQueue<>((c1, c2) -> {
        // 목적지 기준 오름차순 정렬
        if (c1.arrives != c2.arrives) {
            return c1.arrives - c2.arrives;
        } else {
            return c1.departures - c2.departures;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = m;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());

            // 반대로 가길 원하는 승객만
            if (departure > arrive) {
                customers.add(new Customer(departure, arrive));
            }
        }

        long departures = 0;
        long arrives = 0;

        while (!customers.isEmpty()) {
            Customer cur = customers.poll();

            // 이전 승객의 목적지에 가는 동안 현재 태울 승객을 내려줄 수 있을 때
            if (cur.arrives <= departures) {
                // 이전 승객을 내려주지 말고 현재 승객을 먼저 태움
                departures = Math.max(departures, cur.departures);

            // 이전 승객의 목적지에 가는 동안 현재 태울 승객을 내려줄 수 없을 때
            } else {
                // 이전 승객의 목적지를 미리 갔다 옴
                result += 2L * (departures - arrives);

                // 현재 태울 승객을 태움
                departures = cur.departures;
                arrives = cur.arrives;
            }
        }

        result += 2 * (departures - arrives);
        System.out.println(result);
    }

    public static class Customer {
        int departures;
        int arrives;

        public Customer(int departures, int arrives) {
            this.departures = departures;
            this.arrives = arrives;
        }
    }
}