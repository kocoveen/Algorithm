import java.io.*;

public class Main {
    static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            System.out.println((int) Math.sqrt(n));
        }

    }
}