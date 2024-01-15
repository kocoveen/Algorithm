import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);
        int ans = 0;
        while (n-- > 0) {
            a = (a % b) * 10;
            ans = a / b;
        }
        System.out.println(ans);
    }
}