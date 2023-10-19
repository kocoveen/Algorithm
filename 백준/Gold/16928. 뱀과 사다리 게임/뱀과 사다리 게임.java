import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int nm = n + m;
        Map<Integer, Integer> map = new HashMap<>();
        while (nm-- > 0) {
            map.put(sc.nextInt(), sc.nextInt());
        }

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 100) {
                count = cur[1];
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = cur[0] + i;
                if (nx > 100 || visited[nx]) continue;
                visited[nx] = true;
                if (map.containsKey(nx)) {
                    q.add(new int[]{map.get(nx), cur[1] + 1});
                    visited[map.get(nx)] = true;
                } else {
                    q.add(new int[]{nx, cur[1] + 1});
                }
            }
        }
        System.out.println(count);
    }
}