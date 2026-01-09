
public class Main {

    static int[] postorders, inorders, indexes, preorders;
    static int N, index = 0;

    public static void main(String[] args) throws Exception {
        N = read();
        
        postorders = new int[N];
        inorders = new int[N];
        indexes = new int[N];
        preorders = new int[N];

        for (int i = 0; i < N; i++) {
            inorders[i] = read();
            indexes[inorders[i]-1] = i;
        }
        
        for (int i = 0; i < N; i++) {
            postorders[i] = read();
        }

        buildPreOrder(0, N-1, 0, N-1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(preorders[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void buildPreOrder(int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return;
        }

        // 1. 후위 순회 배열로 부모 찾기 (루트는 무조건 마지막)
        int parentValue = postorders[postEnd];

        // 2. 중위 순회 배열에서 부모를 찾고 양 자식의 길이 구하기
        int parentIndexInInorder = indexes[parentValue-1];

        // 3. 오른쪽 트리의 길이를 구함
        int leftSize = parentIndexInInorder - inStart;
        // 4. 양 트리의 후위 중위 위치를 넘겨 재귀
        preorders[index++] = parentValue;
        buildPreOrder(postStart, postStart + leftSize - 1, inStart, parentIndexInInorder - 1);
        buildPreOrder(postStart + leftSize, postEnd - 1, parentIndexInInorder + 1, inEnd);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}