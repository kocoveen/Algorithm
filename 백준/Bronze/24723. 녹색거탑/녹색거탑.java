import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = power(2, N);

        bw.write( result + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++)
            result *= base;
        return result;
    }
}