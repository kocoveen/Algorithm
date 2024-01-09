import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] fib = new int[1000001];
        fib[1] = 1;

        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i - 2] + fib[i - 1]) % 1000000007;
        }

        System.out.println(fib[n]);
    }
}