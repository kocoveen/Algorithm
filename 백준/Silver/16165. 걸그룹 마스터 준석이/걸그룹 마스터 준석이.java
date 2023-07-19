import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);

        Map<String, List<String>> teamMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();

        while (n-- > 0) {
            String tName = br.readLine();
            int size = Integer.parseInt(br.readLine());
            teamMap.put(tName, new ArrayList<>());

            while (size-- > 0) {
                String memberName = br.readLine();
                teamMap.get(tName).add(memberName);
                memberMap.put(memberName, tName);
            }
            Collections.sort(teamMap.get(tName));
        }

        while (m-- > 0) {
            String member = br.readLine();
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                for (String s : teamMap.get(member)) {
                    sb.append(s).append('\n');
                }
            } else {
                sb.append(memberMap.get(member)).append('\n');
            }
        }

        System.out.print(sb);
    }
}