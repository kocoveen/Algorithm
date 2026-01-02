import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    TreeMap<String, Integer> map = new TreeMap<>();
    
    int sum = 0;
    String input;
    while ((input = reader.readLine()) != null) {
      map.merge(input, 1, Integer::sum);
      sum++;
    }
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      writer.write(entry.getKey() + " ");
      writer.write("%.4f\n".formatted((double) entry.getValue() / sum * 100));
    }

    writer.flush();
  }
}