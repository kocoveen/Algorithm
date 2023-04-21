import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            Q.add(i);

        int count = 0;
        while (!Q.isEmpty()) {
            count++;
            if (count == K) {
                if (Q.size() != 1)
                    sb.append(Q.poll()).append(", ");
                else
                    sb.append(Q.poll());
                count = 0;
            } else
                Q.add(Q.poll());
        }
        System.out.print("<");
        System.out.print(sb);
        System.out.print(">");

    }
}