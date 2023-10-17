import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Map<String, Set<String>> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String[] clothes = br.readLine().split(" ");
                map.computeIfAbsent(clothes[1], key -> new HashSet<>()).add(clothes[0]);
            }
            int answer = 1;
            for (String s : map.keySet()) {
                answer *= map.get(s).size() + 1;
            }
            bw.write((answer - 1) + "\n");
        }
        bw.flush();
    }
}