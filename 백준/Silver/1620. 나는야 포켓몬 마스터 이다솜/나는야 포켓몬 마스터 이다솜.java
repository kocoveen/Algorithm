import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);

        int num = 1;
        Map<String, Integer> dict1 = new HashMap<>();
        String[] dict2 = new String[n + 1];
        while (n-- > 0) {
            String mon = br.readLine();
            dict2[num] = mon;
            dict1.put(mon, num++);
        }

        while (m-- > 0) {
            String tmp = br.readLine();
            if ('0' <= tmp.charAt(0) && tmp.charAt(0) <= '9')
                sb.append(dict2[Integer.parseInt(tmp)]).append('\n');
            else
                sb.append(dict1.get(tmp)).append('\n');
        }

        System.out.print(sb);
    }
}