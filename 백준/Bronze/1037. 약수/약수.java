import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int min = 0, max = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i == 0) {
                min = a;
                max = a;
            } else {
                if (min > a)
                    min = a;
                if (max < a)
                    max = a;
            }
        }
        System.out.println(min * max);
    }
}