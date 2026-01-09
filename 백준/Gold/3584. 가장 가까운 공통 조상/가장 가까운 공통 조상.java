
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] parent = new int[N + 1];

            while (N-- > 1) {
                int p = scanner.nextInt();
                int c = scanner.nextInt();
                parent[c] = p;
            }

            int n1 = scanner.nextInt(); // 노드 1
            int n2 = scanner.nextInt(); // 노드 2
            
            List<Integer> parent1 = new ArrayList<>(); // n1의 조상
            parent1.add(n1); // 본인 저장
            List<Integer> parent2 = new ArrayList<>(); // n2의 조상
            parent2.add(n2); // 본인 저장

            // n1 의 조상 전부 저장
            while (parent[n1] != 0) {
                n1 = parent[n1];
                parent1.add(n1);
            }

            // n2 의 조상 전부 저장
            while (parent[n2] != 0) {
                n2 = parent[n2];
                parent2.add(n2);
            }

            System.out.println(findNearestSameParent(parent1, parent2));

        }
    }

    private static int findNearestSameParent(List<Integer> parent1, List<Integer> parent2) {
        for (int node1 : parent1) {
            for (int node2 : parent2) {
                if (node1 == node2) {
                    return node2;
                }
            }
        }
        return -1;
    }
}