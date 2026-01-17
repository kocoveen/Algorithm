import java.util.*;

public class Main {

    static class Class {
        int s, e;
        Class(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Class[] classes = new Class[N];
        for (int i = 0; i < N; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            classes[i] = new Class(s, e);
        }

        // 시작시간 기준
        Arrays.sort(classes, (c1, c2) -> {
            if (c1.s == c2.s) {
                return c1.e - c2.e;
            }
            return c1.s - c2.s;
        });

        // 종료시간 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(classes[0].e);

        for (int i = 1; i < N; i++) {
            if (classes[i].s >= pq.peek()) {
                pq.poll();
            }
            pq.add(classes[i].e);
        }
        System.out.println(pq.size());
    }
}