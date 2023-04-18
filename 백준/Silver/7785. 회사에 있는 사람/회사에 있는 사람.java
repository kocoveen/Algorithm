import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<String, String> log = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter"))
                log.put(name, state);
            else
                log.remove(name);
        }
        List<String> employees = new ArrayList<>(log.keySet());
        Collections.sort(employees, Collections.reverseOrder());

        for (String employee : employees) {
            bw.write(employee + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}