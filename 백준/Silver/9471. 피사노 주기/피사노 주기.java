import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        while (p-- > 0) {
            String[] split = br.readLine().split(" ");
            int t = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);

            int pre2 = 1;
            int pre1 = 1;
            int i = 0;
            do {
                int temp = pre2;
                pre2 = pre1;
                pre1 = (temp + pre1) % m;
                i++;
            } while (pre2 != 1 || pre1 != 1);
            System.out.println(t + " " + i);
        }
    }
}