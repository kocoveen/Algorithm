import java.io.*;

public class Main {
    static int t, r, a = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        do {
            a += 6 * r;
            r++;
        } while (a < t);
        System.out.println(r);
    }
}