import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int q = Integer.parseInt(str.nextToken());

        SegmentTree st = new SegmentTree(n);
        long[] arr = new long[n+1];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(str.nextToken());
        }

        st.init(arr, 1, 1, n);

        for(int i = 0; i < q; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            long ans = x < y ? st.sum(1, 1, n, x, y) : st.sum(1, 1, n, y, x);

            st.update(1, 1, n, Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
            bw.write(ans + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
    
    static class SegmentTree {
        public long[] tree;

        SegmentTree(int n){
            double height = Math.ceil(Math.log(n)/Math.log(2)) + 1;
            long node = Math.round(Math.pow(2, height));
            tree = new long[Math.toIntExact(node)];
        }
        long init(long[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = init(arr, node * 2, start, (start+end)/2) +
                        init(arr, node * 2 +1, (start + end)/2 + 1, end);
            }
        }

        long sum(int node, int start, int end, int left, int right) {
            if(left > end || right < start) {
                return 0;
            } else if(left <= start && right >= end) {
                return tree[node];
            } else {
                return sum(node * 2, start, (start + end)/2, left, right) +
                        sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            }
        }

        long update(int node, int start, int end, int index, long changeValue) {
            if(index < start || index > end) {
                return tree[node];
            } else if(start == index && end == index) {
                return tree[node] = changeValue;
            } else {
                return tree[node] = update(node * 2, start, (start+end)/2, index, changeValue) +
                        update(node * 2 + 1, (start + end)/2 + 1, end, index, changeValue);
            }
        }
    }
}