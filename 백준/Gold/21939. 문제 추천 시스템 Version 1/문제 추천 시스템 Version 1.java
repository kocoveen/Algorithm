import java.util.*;
import java.io.*;


public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    TreeMap<Integer, TreeSet<Integer>> pq = new TreeMap<>();
    // <난이도, <문제>>
    Map<Integer, Integer> map = new TreeMap<>();
    // <문제, 난이도>
    
    int N = Integer.parseInt(reader.readLine());
    while (N-- > 0) {
      String[] line = reader.readLine().split(" ");
      int problem = Integer.parseInt(line[0]);
      int level = Integer.parseInt(line[1]);
      
      pq.computeIfAbsent(level, k -> new TreeSet<>()).add(problem);
      map.put(problem, level);
    }
    
    int M = Integer.parseInt(reader.readLine());
    while (M-- > 0) {
      String[] line = reader.readLine().split(" ");
      String cmd = line[0];
      
      switch (cmd) {
        case "add" -> {
          int arg1 = Integer.parseInt(line[1]); // 문제
          int arg2 = Integer.parseInt(line[2]); // 난이도
          
          pq.computeIfAbsent(arg2, k -> new TreeSet<>()).add(arg1);
          map.put(arg1, arg2);
        }
        case "recommend" -> {
          int arg1 = Integer.parseInt(line[1]);
          if (arg1 > 0) {
            writer.write(pq.lastEntry().getValue().last() + "\n");
          } else {
            writer.write(pq.firstEntry().getValue().first() + "\n");
          }
        }
        case "solved" -> {
          int arg1 = Integer.parseInt(line[1]);
          int level = map.remove(arg1);
          pq.get(level).remove(arg1);
          
          if (pq.get(level).isEmpty()) {
            pq.remove(level);
          }
        }
      }
      writer.flush();
    }
  }
}