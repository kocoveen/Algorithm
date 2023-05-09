import java.io.*;
import java.util.*;

class Top {
    int index;
    int height;

    Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Top> S = new Stack<>();
        S.push(new Top(0, 100000001));

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (S.peek().height < h)
                S.pop();
            sb.append(S.peek().index).append(" ");
            S.push(new Top(i, h));
        }

        System.out.println(sb);

    }
}