import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] input = reader.readLine().split(" ");
    
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    
    String[] dic1 = new String[N+1];
    Map<String, Integer> dic2 = new HashMap<>();
    
    for (int i = 1; i <= N; i++) {
      dic1[i] = reader.readLine();
      dic2.put(dic1[i], i);
    }
    
    for (int i = 1; i <= M; i++) {
      String str = reader.readLine();
      if ('0' <= str.charAt(0) && str.charAt(0) <= '9') {
        writer.write(dic1[Integer.parseInt(str)] + "\n");
      } else {
        writer.write(dic2.get(str) + "\n");
      }
    }
    writer.flush();
  }
}