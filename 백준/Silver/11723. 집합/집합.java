import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        SetImpl S = new SetImpl();
        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            String op = command[0];
            int x = 0;
            if (command.length == 2) {
                x = Integer.parseInt(command[1]);
            }

            switch (command[0]) {
                case "add": {
                    S.add(x);
                    break;
                }
                case "remove": {
                    S.remove(x);
                    break;
                }
                case "check": {
                    bw.write(S.check(x) + "\n");
                    break;
                }
                case "toggle": {
                    S.toggle(x);
                    break;
                }
                case "all": {
                    S.all();
                    break;
                }
                case "empty": {
                    S.empty();
                    break;
                }
            }
        }
        bw.flush();
    }

    static class SetImpl {
        Set<Integer> set;

        public SetImpl() {
            this.set = new HashSet<>();
        }

        public void add(int x) {
            set.add(x);
        }

        public void remove(int x) {
            set.remove(x);
        }

        public int check(int x) {
            return set.contains(x) ? 1 : 0;
        }

        public void toggle(int x) {
            if (check(x) == 1) {
                remove(x);
            } else {
                add(x);
            }
        }

        public void all() {
            set = new HashSet<>();
            IntStream.range(1, 21).forEach(i -> set.add(i));
        }

        public void empty() {
            set.clear();
        }
    }
}
