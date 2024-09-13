import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static int[] A, B;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = read();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = read();

        M = read();
        B = new int[M];
        for (int i = 0; i < M; i++) B[i] = read();

        // 1. 두 수열의 시작점으로부터 공통된 최대값을 찾고 그 인덱스를 저장
        // 2. 저장된 인덱스는 다음 최대값을 찾을 때, 시작값이 됨
        // 3. 1 반복
        int stA = 0, stB = 0; // 수열 시작점 stA, stB
        while (stA < N && stB < M) { // 시작점이 크기보다 크면 나감
            int mxVal = 0, mxIdxA = -1, mxIdxB = -1; // 수열 최대값 및 최대 값 초기화
            for (int i = stA; i < N; i++) {
                for (int j = stB; j < M; j++) {
                    if (A[i] == B[j] && mxVal < A[i]) {
                        mxVal = A[i];
                        mxIdxA = i;
                        mxIdxB = j;
                    }
                }
            }

            if (mxIdxA != -1 && mxIdxB != -1) {
                list.add(A[mxIdxA]);
                stA = mxIdxA + 1;
                stB = mxIdxB + 1;
            } else break;
        }

        System.out.println(list.size());
        for (int i : list) System.out.print(i + " ");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}