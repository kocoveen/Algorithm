import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] inorders;
    static int[] postorders;
    static int[] indexes;
    static int N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inorders = new int[N+1];
        postorders = new int[N+1];
        indexes = new int[N+1]; // inorder 의 index 정보 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inorders[i] = Integer.parseInt(st.nextToken());
            indexes[inorders[i]] = i;

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            postorders[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, N, 1, N);
        System.out.print(sb);
    }

    private static void dfs(int in_si, int in_ei, int post_si, int post_ei) {

        // 분할 불가
        if (in_si > in_ei || post_si > post_ei) {
            return;
        }

        int rootIndex = indexes[postorders[post_ei]];
        int leftSize = rootIndex - in_si;
        int rightSize = in_ei - rootIndex;

        sb.append(postorders[post_ei]).append(" ");

        // 좌자식트리
        dfs(in_si, rootIndex - 1, post_si, post_si + leftSize - 1);
        // 우자식트리
        dfs(rootIndex + 1, in_ei, post_si + leftSize, post_ei - 1);
    }

    private static int findRootInInorder(int value) {
        for (int i = 0; i < N; i++) {
            if (inorders[i] == value) {
                return i;
            }
        }
        return -1;
    }
}