import java.io.*;

public class Main {
    // 빠른 입력을 위한 버퍼
    private static final int BUF_SIZE = 1 << 16;
    private static byte[] buf = new byte[BUF_SIZE];
    private static int len = 0, ptr = 0;

    static int read() throws Exception {
        int n = 0;
        byte c = readByte();
        while (c <= 32) c = readByte();
        while (c > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
            c = readByte();
        }
        return n;
    }

    static byte readByte() throws Exception {
        if (ptr == len) {
            len = System.in.read(buf, 0, BUF_SIZE);
            if (len == -1) return -1;
            ptr = 0;
        }
        return buf[ptr++];
    }

    public static void main(String[] args) throws Exception {
        int K = read();
        int W = read();
        int H = read();

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        // 1차원 배열로 맵 저장 (메모리 참조 효율 극대화)
        boolean[] isWall = new boolean[H * W];
        for (int i = 0; i < H * W; i++) {
            if (read() == 1) isWall[i] = true;
        }

        // 1차원 방문 배열 [K+1][H][W] -> (k * H * W) + (r * W) + c
        int HW = H * W;
        boolean[] visited = new boolean[(K + 1) * HW];

        // 직접 구현한 배열 큐 (객체 생성 0)
        // 최대 크기: K(31) * H(200) * W(200)
        int[] queue = new int[(K + 1) * HW];
        int head = 0, tail = 0;

        // 초기값: (k << 16) | (r << 8) | c
        queue[tail++] = 0; 
        visited[0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int[] dhr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dhc = {-1, 1, -2, 2, -2, 2, -1, 1};

        int steps = 0;
        while (head < tail) {
            steps++;
            int size = tail - head;
            
            while (size-- > 0) {
                int curr = queue[head++];
                int ck = (curr >> 16) & 0xFF;
                int cr = (curr >> 8) & 0xFF;
                int cc = curr & 0xFF;

                // 1. 일반 이동
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        int nextPos = nr * W + nc;
                        int nextIdx = (ck * HW) + nextPos;
                        if (!isWall[nextPos] && !visited[nextIdx]) {
                            if (nr == H - 1 && nc == W - 1) {
                                System.out.println(steps);
                                return;
                            }
                            visited[nextIdx] = true;
                            queue[tail++] = (ck << 16) | (nr << 8) | nc;
                        }
                    }
                }

                // 2. 말 이동
                if (ck < K) {
                    int nk = ck + 1;
                    for (int i = 0; i < 8; i++) {
                        int nr = cr + dhr[i];
                        int nc = cc + dhc[i];
                        if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                            int nextPos = nr * W + nc;
                            int nextIdx = (nk * HW) + nextPos;
                            if (!isWall[nextPos] && !visited[nextIdx]) {
                                if (nr == H - 1 && nc == W - 1) {
                                    System.out.println(steps);
                                    return;
                                }
                                visited[nextIdx] = true;
                                queue[tail++] = (nk << 16) | (nr << 8) | nc;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}