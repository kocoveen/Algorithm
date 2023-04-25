import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] A;
    static int[] Op;

    static int[] seq;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        A = new int[N]; Op = new int[4]; seq = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            Op[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);

    }

    public static void dfs(int startIndex) {
        if (seq.length == startIndex) {
            result = Calculate();
            if (max < result)
                max = result;
            if (min > result)
                min = result;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (Op[i] == 0) continue;
            seq[startIndex] = i;
            Op[i]--;
            dfs(startIndex + 1);
            Op[i]++;
        }
    }
    
    public static int Calculate() {
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = Operate(result, A[i], seq[i-1]);
        }
        return result;
    }

    public static int Operate(int Op1, int Op2, int Operator) {
        if (Operator == 0)
            return Op1 + Op2;
        else if (Operator == 1)
            return Op1 - Op2;
        else if (Operator == 2)
            return Op1 * Op2;
        else {
            if (Op1 < 0 && Op2 > 0)
                return -((-Op1) / Op2);
            return Op1 / Op2;
        }
    }
}