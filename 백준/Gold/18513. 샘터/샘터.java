import java.util.*;

public class Main {
    
    static int N, K; // 샘터, 집
    // int[] {현재 위치, 샘터로부터의 거리}
    static Queue<int[]> queue = new ArrayDeque<>();
    static Set<Integer> visit = new HashSet<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int wellPos = sc.nextInt();
            visit.add(wellPos);
            queue.add(new int[]{wellPos, 0});
        }

        long total = 0;
        int house = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currPos = curr[0];
            int currDis = curr[1];

            // 현재 위치 좌우 확인
            int[] dir = {currPos-1, currPos+1};

            for (int nextPos : dir) {
                if (!visit.contains(nextPos)) {
                    visit.add(nextPos);

                    // 집 지은 후, 불행도 합산
                    house++;
                    total += (currDis + 1);

                    // 목표한 집 개수를 모두 채우면 종료
                    if (house == K) {
                        System.out.println(total);
                        return;
                    }

                    // 다음 탐색을 위해 큐에 추가 (거리 +1)
                    queue.add(new int[]{nextPos, currDis+1});
                }
            }
        }
    }
}