import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static long n, m, result;
    static List<Customer> customers = new ArrayList<>();

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

        Collections.sort(customers);

        long departures = customers.get(0).departures;
        long arrives = customers.get(0).arrives;

        for (int i = 1; i < customers.size(); i++) {
            // 다음 승객 정보
            long start = customers.get(i).departures;
            long end = customers.get(i).arrives;

            // 이전 승객의 목적지에 가는 동안 현재 태울 승객을 내려줄 수 있을 때
            if (end <= departures) {
                // 이전 승객을 내려주지 말고 현재 승객을 먼저 태움
                departures = Math.max(departures, start);

            // 이전 승객의 목적지에 가는 동안 현재 태울 승객을 내려줄 수 없을 때
            } else {
                // 이전 승객의 목적지를 미리 갔다 옴
                result += 2 * (departures - arrives);

                // 현재 태울 승객을 태움
                departures = start;
                arrives = end;
            }
        }

        result += 2 * (departures - arrives);
        System.out.println(result);
    }

    public static class Customer implements Comparable<Customer> {
        int departures;
        int arrives;

        public Customer(int departures, int arrives) {
            this.departures = departures;
            this.arrives = arrives;
        }

        // 목적지 기준 오름차순 정렬
        @Override
        public int compareTo(Customer o) {
            if (this.arrives != o.arrives) {
                return this.arrives - o.arrives;
            } else {
                return this.departures - o.departures;
            }
        }
    }
}