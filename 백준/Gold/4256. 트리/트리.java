import java.util.Scanner;

public class Main {

    static int[] preorders, inorders;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            N = scanner.nextInt();
            
            preorders = new int[N];
            inorders = new int[N];

            for (int i = 0; i < N; i++) {
                preorders[i] = scanner.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                inorders[i] = scanner.nextInt();
            }

            buildPostOrder(0, N-1, 0, N-1);
            System.out.println();
        }
    }

    private static void buildPostOrder(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }

        // 1. 전위 순회 배열로 부모 찾기 (루트는 무조건 0)
        int parentValue = preorders[preStart];

        // 2. 중위 순회 배열에서 부모를 찾고 양 자식의 길이 구하기
        int parentIndexInInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorders[i] == parentValue) {
                parentIndexInInorder = i;
                break;
            }
        }

        // 3. 왼쪽 트리의 길이를 구함
        int leftSize = parentIndexInInorder - inStart;

        // 4. 양 트리의 전위 중위 위치를 넘겨 재귀
        buildPostOrder(preStart + 1, preStart + leftSize, inStart, parentIndexInInorder - 1);
        buildPostOrder(preStart + leftSize + 1, preEnd, parentIndexInInorder + 1, inEnd);
        System.out.print(parentValue + " ");
    }
}