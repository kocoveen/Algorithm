import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] k = new int[8];
    static boolean asc;
    static boolean desc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 8; i++)
            k[i] = Integer.parseInt(st.nextToken());

        asc = true;
        desc = true;
        for (int i = 0; i < 7; i++) {
            if (k[i] < k[i+1])
                desc = false;
            if (k[i] > k[i+1])
                asc = false;
        }

        if (asc)
            System.out.println("ascending");
        else if (desc)
            System.out.println("descending");
        else
            System.out.println("mixed");

    }
}