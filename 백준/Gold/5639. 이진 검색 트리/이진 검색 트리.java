import java.util.*;

public class Main {

    static int count = 0;
    static int[] tree = new int[10001];
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            tree[count++] = scanner.nextInt();
        }

        postorder(0, count - 1);
    }

    private static void postorder(int start, int end) throws Exception {
        if (start > end) return;

        int parent = tree[start];
        
        int mid = start + 1;
        while (mid <= end && tree[mid] < parent) {
            mid++;
        }

        postorder(start + 1, mid - 1);
        postorder(mid, end);
        System.out.println(parent);
    }
}