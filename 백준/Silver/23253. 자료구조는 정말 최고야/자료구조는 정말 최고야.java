import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int[][] books;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        books = new int[m][];

        for (int i = 0; i < m; i++) {
            int cnt = Integer.parseInt(br.readLine());
            books[i] = new int[cnt];
            split = br.readLine().split(" ");
            for (int j = 0; j < cnt; j++) {
                books[i][j] = Integer.parseInt(split[j]);
            }

            for (int j = 0; j < cnt - 1; j++) {
                if (books[i][j] < books[i][j + 1]) {
                    System.out.println("No");
                    System.exit(0);
                }
            }
        }
        System.out.println("Yes");
    }
}