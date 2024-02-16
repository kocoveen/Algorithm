public class Main {

    static int n, idx = 1;
    static int[] preTree;
    static int[] postTree;
    static int[] inTree;
    static int[] indexes; // inTree 값의 인덱스 저장

    public static void main(String[] args) throws Exception {
        n = read();
        preTree = new int[n + 1];
        inTree = new int[n + 1];
        postTree = new int[n + 1];

        indexes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            inTree[i] = read();
            indexes[inTree[i]] = i;
        }

        for (int i = 1; i <= n; i++) postTree[i] = read();

        dfs(1, n + 1, 1, n + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(preTree[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int in_st, int in_en, int post_st, int post_en) {

        if (in_st >= in_en || post_st >= post_en) return;

        int root = postTree[post_en - 1];

        preTree[idx++] = root;

        int in_root_index = indexes[root];

        int l_size = in_root_index - in_st; // 좌측 자식 트리 size
        int r_size = in_en - in_root_index - 1; // 우측 자식 트리 size

        int l_in_st = in_st;
        int l_in_en = l_in_st + l_size;
        int l_post_st = post_st;
        int l_post_en = post_st + l_size;

        int r_in_st = in_root_index + 1;
        int r_in_en = r_in_st + r_size;
        int r_post_st = post_st + l_size;
        int r_post_en = r_post_st + r_size;

        dfs(l_in_st, l_in_en, l_post_st, l_post_en);
        dfs(r_in_st, r_in_en, r_post_st, r_post_en);
    }


    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}