import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int C = 1_000_000_007;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] split = br.readLine().split(" ");
            long n = Long.parseLong(split[0]);
            long s = Long.parseLong(split[1]);
            answer += (s * power(n, C - 2)) % C;
        }
        System.out.println(answer % C);

    }

    public static long power(long n, long m){
        long ret = 1;
        while (m > 0) {
            if ((m & 1) > 0) ret = ret * n % C;
            m = m / 2;
            n = n * n % C;
        }
        return ret;
    }
}