import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] rooms = new int[N][2];
        for (int i = 0; i < N; i++) {
            rooms[i][0] = scanner.nextInt();
            rooms[i][1] = scanner.nextInt();
        }

        Arrays.sort(rooms, (int[] r1, int[] r2) -> {
            if (r1[0] == r2[0]) {
                return r1[1] - r2[1];
            }
            return r1[0] - r2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(rooms[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= rooms[i][0]) {
                pq.poll();
            }
            pq.add(rooms[i][1]);
        }

        System.out.println(pq.size());
    }
}