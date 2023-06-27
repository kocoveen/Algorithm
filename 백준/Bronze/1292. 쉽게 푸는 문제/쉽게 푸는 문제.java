import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int A = Integer.parseInt(l[0]);
        int B = Integer.parseInt(l[1]);

        System.out.println(func(B) - func(A - 1));

    }

    private static int func(int n) {
        int i = 1, sum = 0;
        while (n > i) {
            sum += i * i;
            n -= i++;
        }
        return sum + i * n;
    }
}