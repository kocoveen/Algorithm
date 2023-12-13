import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] applicants = new int[n+1]; //서류 순위 : 면접 순위
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); //서류 순위
                int b = Integer.parseInt(st.nextToken()); //면접 순위
                applicants[a] = b;
            }

            int count = 1; // 최고 서류 순위는 무조건 뽑음
            int rank = applicants[1]; //최고 면접 순위
            for (int i = 2; i <= n; i++) {
                //현재 지원자 면접 순위가 최고 면접 순위보다 높으면 
                if (applicants[i] < rank) {
                    count++;
                    rank = applicants[i]; //최고 면접 순위 갱신
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}