import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    int N = read();
    PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1- i2);
    
    while (N-- > 0) {
      int x = read();
      if (x == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(pq.remove());
        }
      } else {
        pq.insert(x);
      }
    }
  }
  
  static class PriorityQueue<T> {
    private final List<T> queue;
    private final Comparator<? super T> comparator;
    
    public PriorityQueue(int capacity) {
      this(null);
    }
    
    public PriorityQueue(Comparator<T> comparator) {
      this.queue = new ArrayList<>();
      this.comparator = comparator;
    }
    
    public void insert(T item) {
      queue.add(item);
      upHeap(queue.size() - 1);
    }
    
    public T remove() {
      if (queue.isEmpty()) return null;
      
      T root = queue.get(0);
      T lastItem = queue.remove(queue.size() - 1);
      
      if (!queue.isEmpty()) {
        queue.set(0, lastItem);
        downHeap(0);
      }
      return root;
    }
    
    private void upHeap(int index) {
      T key = queue.get(index);
      while (index > 0) {
        int parentIdx = (index - 1) / 2;
        T parent = queue.get(parentIdx);
        
        if (compare(key, parent) <= 0) break;
        
        queue.set(index, parent);
        index = parentIdx;
      }
      queue.set(index, key);
    }
    
    private void downHeap(int index) {
      T key = queue.get(index);
      int size = queue.size();
      
      while (index < size / 2) {
        int leftChild = 2 * index + 1;
        int rightChild = leftChild + 1;
        int largerChild = leftChild;
        
        if (rightChild < size && compare(queue.get(leftChild), queue.get(rightChild)) < 0) {
          largerChild = rightChild;
        }
        
        if (compare(key, queue.get(largerChild)) >= 0) break;
        
        queue.set(index, queue.get(largerChild));
        index = largerChild;
      }
      queue.set(index, key);
    }
    
    private int compare(T a, T b) {
      if (comparator != null) {
        return comparator.compare(a, b);
      }
      return ((Comparable<? super T>) a).compareTo(b);
    }
    
    public int size() {
      return queue.size();
    }
    
    public boolean isEmpty() {
      return queue.isEmpty();
    }
  }
  
  static int read() throws Exception {
    int c, n = System.in.read() & 15;
    while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
    return n;
  }
}