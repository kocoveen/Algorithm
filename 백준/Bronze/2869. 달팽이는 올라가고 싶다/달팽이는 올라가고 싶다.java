import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int A, B, V, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        A = Integer.parseInt(l[0]);
        B = Integer.parseInt(l[1]);
        V = Integer.parseInt(l[2]);

        if ((V - B) % (A - B) == 0) ans = (V - B) / (A - B);
        else ans = (V - B) / (A - B) + 1;
        System.out.println(ans);
    }
}