import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int sz = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> D = new ArrayDeque<>();
            for (int j = 0; j < sz; j++)
                D.addLast(Integer.parseInt(st.nextToken()));

            int rCount = 0;
            boolean isError = false;
            for (int j = 0; j < cmd.length(); j++) {
                if (isError) break;
                char c = cmd.charAt(j);
                if (c == 'R') {
                    rCount++;
                } else {
                    if (D.size() == 0)
                        isError = true;
                    else
                        delete(D, rCount);
                }
            }

            if (!isError) {
                int Dsize = D.size();
                sb.append("[");
                for (int j = 0; j < Dsize; j++) {
                    if (D.size() != 1)
                        sb.append(delete(D, rCount)).append(",");
                    else
                        sb.append(delete(D, rCount));
                }
                sb.append("]").append("\n");
            } else
                sb.append("error").append("\n");

        }
        bw.write(sb + "");
        bw.flush();
    }
    private static int delete(Deque<Integer> D, int rCount) {
        if (rCount % 2 == 0)
            return D.removeFirst();
        return D.removeLast();
    }
}