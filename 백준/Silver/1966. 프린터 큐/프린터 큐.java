import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            Queue<Document> Q = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // 문서 집어넣기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int p = Integer.parseInt(st.nextToken());
                Q.add(new Document(j, p));
            }

            int count = 0;
            while (true) {
                int max = 0;
                for (Document d1 : Q)
                    if (max < d1.priority)
                        max = d1.priority;
                
                Document d0 = Q.poll();
                
                if (d0.priority < max) {
                    Q.add(d0);
                    continue;
                }
                else if (d0.priority == max)
                    count++;
                
                if (d0.num == M)
                    break;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    private static class Document {
        int num;
        int priority;

        public Document(int i, int p) {
            this.num = i;
            this.priority = p;
        }
    }
}