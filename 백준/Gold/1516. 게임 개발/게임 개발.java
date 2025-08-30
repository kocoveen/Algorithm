import java.util.*;

class Main {
    static int N;
    static int[] times, counts, timesSum;
    static List<List<Integer>> lists = new ArrayList<>();
    static Deque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());
        times = new int[N]; // 각 건물 빌드 타임
        timesSum = new int[N]; // 각 건물 총 빌드 타임
        counts = new int[N]; // 각 건물의 다음 건물 수

        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int time = Integer.parseInt(tokens[0]);

            times[i] = time;
            timesSum[i] = time;

            for (int j = 1; j < tokens.length-1; j++) {
                int node = Integer.parseInt(tokens[j]) - 1;
                lists.get(node).add(i);
                counts[i]++;
            }
        }

        // 큐에 size 0 인거 넣기
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) Q.addLast(i);
        }

        while (!Q.isEmpty()) {
            int cur = Q.removeFirst();

            for (int next : lists.get(cur)) {
                counts[next]--;
                timesSum[next] = Math.max(timesSum[next], timesSum[cur] + times[next]); // 가장 큰 빌드 타임을 선택
                if (counts[next] == 0) {
                    Q.addLast(next);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(timesSum[i]);
        }
    }
}