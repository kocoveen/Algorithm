import java.util.*;

public class Main {

    static int N;
    static long M;
    static long line[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextLong();

        line = new long[N];
        long maxT = 0; // 각 심사를 하는데 걸리는 시간 중 최대 시간

        for (int i = 0; i < N; i++) {
            line[i] = sc.nextLong();
            maxT = Math.max(maxT, line[i]);
        }

        // 이분 탐색 범위 설정: 최소 1초 ~ 최대 (가장 오래 걸리는 심사대 * M명)
        long l = 0;
        long r = maxT * M;

        while (l < r) {
            long m = l + (r - l) / 2;
            if (getCount(m) >= M) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        System.out.println(l);
    }

    // T초 동안 처리할 수 있는 최대 인원: T / 심사시간
    private static long getCount(long t) {
        long people = 0;
        for (int i = 0; i < N; i++) {
            people += (t / line[i]); // 라인 i에서 t초동안 처리 가능한 사람

            // 오버플로우 방지, 이미 m명을 넘겼다면 더 계산할 필요 없음
            if (people >= M) break;
        }
        return people;
    }
}