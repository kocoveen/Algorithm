import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Set<String> nick = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals("ChongChong") || B.equals("ChongChong")) {
                nick.add(A);
                nick.add(B);
            }

            if (nick.contains(A) || nick.contains(B)) {
                nick.add(A);
                nick.add(B);
            }
        }

        System.out.println(nick.size());
    }
}