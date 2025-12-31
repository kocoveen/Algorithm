import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int T = Integer.parseInt(reader.readLine());
    
    while (T-- > 0) {
      String[] line = reader.readLine().split(" ");
      int N = Integer.parseInt(line[0]);
      int M = Integer.parseInt(line[1]);
      
      Deque<Document> dq = new ArrayDeque<>();
      
      String[] priorities = reader.readLine().split(" ");
      
      for (int i = 0; i < priorities.length; i++) {
        int p = Integer.parseInt(priorities[i]);
        dq.addLast(new Document(i, p));
      }
      
      int maxPriority = getPriority(dq);
      int count = 0;
      while (!dq.isEmpty()) {
        Document d = dq.removeFirst();
        // 중요도가 높은 문서가 하나라도 있다면
        if (maxPriority > d.priority) {
          dq.addLast(d);
          continue;
        }
        
        // 아니면,
        maxPriority = getPriority(dq);
        count++;
        
        if (d.index == M) {
          writer.write(count + "\n");
          break;
        }
      }
      writer.flush();
    }
  }
  
  private static int getPriority(Deque<Document> dq) {
    int maxPriority = 0;
    for (Document doc : dq) {
      if (maxPriority < doc.priority) {
        maxPriority = doc.priority;
      }
    }
    return maxPriority;
  }
  
  static class Document {
    int index;
    int priority;
    
    public Document(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }
}