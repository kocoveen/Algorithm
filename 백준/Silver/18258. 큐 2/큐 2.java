import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(reader.readLine());
    
    Queue queue = new Queue(N);
    
    while(N-- > 0) {
      String[] line = reader.readLine().split(" ");
      switch (line[0]) {
        case "push": {
          int x = Integer.parseInt(line[1]);
          queue.push(x);
          break;
        }
        case "pop": {
          writer.write(String.valueOf(queue.pop()));
          writer.newLine();
          break;
        }
        case "size": {
          writer.write(String.valueOf(queue.size()));
          writer.newLine();
          break;
        }
        case "empty": {
          writer.write(String.valueOf(queue.empty()));
          writer.newLine();
          break;
        }
        case "front": { 
          writer.write(String.valueOf(queue.front()));
          writer.newLine();
          break;
        }
        case "back": { 
          writer.write(String.valueOf(queue.back()));
          writer.newLine();
          break;
        }
      }
    }
    writer.flush();
  }
  
  static class Queue {
    private int[] data;
    private int front;
    private int back;
    
    public Queue(int N) {
      this.data = new int[N];
      this.front = -1;
      this.back = -1;
    }
    
    public void push(int x) {
      data[++back] = x;
    }
    
    public int pop() {
      return empty() == 1 ? -1 : data[++front];
    }
    
    public int size() {
      return back - front;
    }
    
    public int empty() {
      return size() == 0 ? 1 : 0;
    }
    
    public int front() {
      return empty() == 1 ? -1 : data[front + 1];
    }
    
    public int back() {
      return empty() == 1 ? -1 : data[back];
    }
  }
}