import java.util.*;

public class Main {

    static int[] s;
    static State[] v;
    static boolean[] f;
    static int count = 0;

    static enum State {
        VISITED, NOT_VISITED, CYCLE_IN, NOT_CYCLE_IN
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            s = new int[n+1];
            v = new State[n+1];
            count = 0;

            for (int i = 1; i <= n; i++) {
                s[i] = sc.nextInt();
                v[i] = State.NOT_VISITED;
            }

            for (int i = 1; i <= n; i++) {
                if (v[i] == State.NOT_VISITED) {
                    run(i);
                }
            }

            System.out.println(n - count);
        }
    }

    private static void run(int start) {
        int cur = start;
        
        // 1. 탐색 (임시 방문 표시)
        while (v[cur] == State.NOT_VISITED) {
            v[cur] = State.VISITED;
            cur = s[cur];
        }

        // 2. 사이클 발견 시 처리
        if (v[cur] == State.VISITED) {
            int temp = cur;
            // 사이클을 한 바퀴 돌며 CYCLE_IN으로 바꾸고 개수 세기
            while (v[temp] != State.CYCLE_IN) {
                v[temp] = State.CYCLE_IN;
                count++; // 여기서 팀이 된 사람을 직접 카운트
                temp = s[temp];
            }
        }

        // 3. 나머지(진입로 등)는 NOT_CYCLE_IN으로 정리
        int temp = start;
        while (v[temp] == State.VISITED) {
            v[temp] = State.NOT_CYCLE_IN;
            temp = s[temp];
        }
    }
} 