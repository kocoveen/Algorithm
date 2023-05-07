import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] A;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    count++;
            }
            switch (count) {
                case 4: sb.append("E").append("\n"); break;
                case 0: sb.append("D").append("\n"); break;
                case 1: sb.append("C").append("\n"); break;
                case 2: sb.append("B").append("\n"); break;
                case 3: sb.append("A").append("\n"); break;
            }
        }
        System.out.print(sb);

    }

}