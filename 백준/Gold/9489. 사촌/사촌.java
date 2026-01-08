public class Main {
    public static void main(String[] args) throws Exception {
        int n, k;
        while ((n = read()) != 0 && (k = read()) != 0) {
            
            int[] nodes = new int[n]; // 노드 기록
            int[] parent = new int[n]; // 부모 노드 기록
            int targetIndex = 0; // 찾으려는 인덱스

            // root 부모 노드는 없으므로 -1
            parent[0] = -1;
            int parentIndex = -1; // 부모를 가리키는 인덱스

            for (int i = 0; i < n; i++) {
                nodes[i] = read();
 
                // 노드가 찾으려는 k이면
                if (nodes[i] == k) {
                    targetIndex = i;
                }

                // 1. 연속되지 않은 숫자가 나오면 부모 인덱스를 다음으로 넘김
                if (i > 0 && nodes[i] != nodes[i - 1] + 1) {
                    parentIndex++;
                }

                // 2. 현재 노드의 부모 설정
                parent[i] = parentIndex;
                
            }
            
            // 사촌 찾기
            // 부모는 다름 && 부모의 부모가 같은 경우
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (parent[i] != parent[targetIndex] 
                    && parent[parent[i]] == parent[parent[targetIndex]]) {
                        count++;
                }
            }
            System.out.println(count);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}