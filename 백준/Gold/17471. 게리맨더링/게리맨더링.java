import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static List<Integer>[] graph;
    static int[] pop;
    static int mn = Integer.MAX_VALUE;
    static int setBit = 2;
    static int fullBit;

    public static void main(String[] args) throws Exception {
        n = read();
        pop = new int[n + 1];
        for (int i = 1; i <= n; i++) pop[i] = read();

        fullBit = (1 << (n + 1)) - 2;

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            int k = read();
            for (int j = 0; j < k; j++) {
                graph[i].add(read());
            }
        }

        for (int i = 1; i < n; i++) {
            makeSet(i, 1, 1, setBit);
        }

        System.out.println(mn == Integer.MAX_VALUE ? -1 : mn);

    }

    private static void makeSet(int end, int depth, int cur, int setBit) {
        if (depth == end) {
            int aSetBit = linkCheck(setBit, 2, 1);
            int complement = getComplement(~setBit);
            int bSetBit = linkCheck(~setBit, 1 << complement, complement);

            if (isAllLinked(setBit, aSetBit, bSetBit)) {
                int diffPop = getDiffPop(setBit);
                mn = Math.min(mn, diffPop);
            }
            return;
        }

        for (int i = cur; i <= n; i++) {
            if ((setBit & (1 << i)) == (1 << i)) continue;
            setBit |= (1 << i);
            makeSet(end, depth + 1, i, setBit);
            setBit &= ~(1 << i);
        }
    }

    private static int linkCheck(int setBit, int tmpSetBit, int complement) {
        for (int i : graph[complement]) {
            if ((tmpSetBit & (1 << i)) == (1 << i)) continue;
            if ((setBit & (1 << i)) != (1 << i)) continue;
            tmpSetBit |= linkCheck(setBit, tmpSetBit | (1 << i), i);
        }
        return tmpSetBit;
    }

    private static int getComplement(int setBit) {
        int complement = -1;
        for (int i = 1; i <= n; i++) {
            if ((setBit & (1 << i)) != (1 << i)) continue;
            complement = i;
            break;
        }
        return complement;
    }

    private static int getDiffPop(int setBit) {
        int popDiff = 0;
        for (int i = 1; i <= n; i++) {
            if ((setBit & (1 << i)) == (1 << i)) popDiff += pop[i];
            else popDiff -= pop[i];
        }
        return Math.abs(popDiff);
    }

    private static boolean isAllLinked(int setBit, int aSetBit, int bSetBit) {
        return setBit == aSetBit && (~setBit & fullBit) == bSetBit;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}