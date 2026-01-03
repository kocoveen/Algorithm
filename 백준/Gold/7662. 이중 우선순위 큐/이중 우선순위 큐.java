import java.util.*;
import java.io.*;


public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(reader.readLine());
    
    while (T-- > 0) {
      TreeMap<Integer, Integer> dpq = new TreeMap<>();
      int k = Integer.parseInt(reader.readLine());
      
      while (k-- > 0) {
        String[] line = reader.readLine().split(" ");
        String cmd = line[0];
        int arg = Integer.parseInt(line[1]);
        if (cmd.equals("I")) {
          dpq.merge(arg, 1, Integer::sum);
        } else {
          if (dpq.isEmpty()) {
            continue;
          }
          if (arg > 0) {
            // 최대값
            int key = dpq.lastKey();
            if (dpq.get(key) == 1) {
              dpq.remove(key);
            } else {
              dpq.merge(key, -1, Integer::sum);
            }
          } else {
            // 최소값
            int key = dpq.firstKey();
            if (dpq.get(key) == 1) {
              dpq.remove(key);
            } else {
              dpq.merge(key, -1, Integer::sum);
            }
          }
        }
      }
      
      if (dpq.isEmpty()) {
        writer.write("EMPTY");
      } else {
        writer.write(dpq.lastKey() + " " + dpq.firstKey());
      }
      writer.write("\n");
      writer.flush();
    }
  }
}