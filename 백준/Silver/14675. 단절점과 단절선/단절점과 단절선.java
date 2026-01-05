import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 트리에서 단절점 : 터미널 노드면 단절점 X, 나머지는 O
     * 2. 트리에서 단절선 : 어떤 선을 잘라도 단절선
     */
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] fanOut = new int[n + 1];

        String[] line;
        while (true) {
            line = reader.readLine().split(" ");
            if (line.length == 1) {
                break;
            } 
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            fanOut[u]++;
            fanOut[v]++;
        }

        int q = Integer.parseInt(line[0]);
        while (q-- > 0) {
            line = reader.readLine().split(" ");
            int cmd = Integer.parseInt(line[0]);
            int arg = Integer.parseInt(line[1]); // k

            if (cmd != 1) {
                System.out.println("yes");
            } else {
                if (fanOut[arg] == 1) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
        }
    }
}