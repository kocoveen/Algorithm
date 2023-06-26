import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (A % 5 != 0 && A >= 3) {
            A -= 3;
            cnt++;
        }

        if (A == 1 || A == 2) System.out.println(-1);
        else System.out.println(A / 5 + cnt);

    }
}