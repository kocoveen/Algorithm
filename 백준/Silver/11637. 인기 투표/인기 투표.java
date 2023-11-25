import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] candidates = new int[n + 1];
            int totalTally = 0;
            for (int candidateNum = 1; candidateNum <= n; candidateNum++) {
                int tally = Integer.parseInt(br.readLine());
                candidates[candidateNum] = tally;
                totalTally += tally;
            }

            int maxIndex = 0, max = Integer.MIN_VALUE, count = 0;
            for (int i = 1; i <= n; i++) {
                candidates[i] -= (totalTally - candidates[i]);
                if (max < candidates[i]) {
                    max = candidates[i];
                    maxIndex = i;
                    count = 1;
                } else if (max == candidates[i]) {
                    count++;
                }
            }
            sb.append(getResult(max, maxIndex, count)).append('\n');
        }
        System.out.print(sb);
    }

    public static String getResult(int max, int maxIndex, int count) {
        String result = "";
        if (count == 1) {
            result = max > 0 ? "majority " : "minority ";
            result += "winner ";
            result += maxIndex;
        } else {
            result += "no ";
            result += "winner";
        }
        return result;
    }
}