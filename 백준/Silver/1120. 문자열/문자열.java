import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String a, b;
    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int count = getSameCount(a, b, i);
            if (mn > count) {
                mn = count;
            }
        }
        System.out.println(mn);
    }

    private static int getSameCount(String a, String b, int idx) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(idx + i)) {
                count++;
            }
        }
        return count;
    }
}