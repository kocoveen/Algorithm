import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());

        List<List<Integer>> Cases = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            List<Integer> students = new ArrayList<>();
            Cases.add(students);
            for (int j = 0; j < N; j++) {
                students.add(Integer.valueOf(st.nextToken()));
            }
        }

        List<Double> avgs = new ArrayList<>();

        for (int i = 0; i < Cases.size(); i++) {
            Integer sum = 0;
            for (int j = 0; j < Cases.get(i).size(); j++) {
                sum += Cases.get(i).get(j);
            }
            avgs.add(Double.valueOf(sum / Cases.get(i).size()));
        }

        for (int i = 0; i < Cases.size(); i++) {
            int cnt = 0;
            for (Integer S : Cases.get(i)) {
                if(S > avgs.get(i))
                    cnt++;
            }
            Double av = (double) cnt / Cases.get(i).size() * 100;
            bw.write(String.format("%.3f%%\n", av));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}