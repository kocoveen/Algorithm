import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] line;
    static int[] teamSize = new int[500005];
    static int n, h, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> studentMap = new TreeMap<>();

        List<List<Integer>> teamList = new ArrayList<>();

        while (n-- > 0) {
            line = br.readLine().split(" ");
            h = Integer.parseInt(line[0]);
            k = Integer.parseInt(line[1]);

            studentMap.put(h, k);
        }

        int lastIdx = 0;
        while (!studentMap.isEmpty()) {
            Integer H = studentMap.lastKey();
            Integer K = studentMap.get(H);


            if (lastIdx == 0) {
                teamSize[lastIdx++]++;
                studentMap.remove(H);
//                System.out.println(H + " " + 0);
                continue;
            }

            int i = binarySearch(K, lastIdx);
            teamSize[i]++;
            studentMap.remove(H);

            if (i == lastIdx) lastIdx++;

//            extracted(studentMap, teamList, H, K);
        }

        System.out.println(lastIdx);
//        printTeam(teamList);
//        System.out.println(teamList.size());
    }

    private static int binarySearch(Integer k, int lastIdx) {
        int l = 0, r = lastIdx, mid = (l + r) / 2, K = k - 1;
        while (l < r) {
            if (teamSize[mid] < K) {
                r = mid;
            } else if (teamSize[mid] > K) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    private static void extracted(TreeMap<Integer, Integer> studentMap, List<List<Integer>> teamList, Integer H, Integer K) {
        if (teamList.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(H);
            teamList.add(tmp);
            studentMap.remove(H);
            return;
        }

        for (List<Integer> team : teamList) {
            if (team.size() >= K) continue;
            team.add(H);
            studentMap.remove(H);
            break;
        }

        if (!studentMap.containsKey(H)) return;

        List<Integer> tmp = new ArrayList<>();
        tmp.add(H);
        teamList.add(tmp);
        studentMap.remove(H);
    }

    private static void printTeam(List<List<Integer>> teamList) {
        for (List<Integer> team : teamList) {
            for (Integer member : team) {
                System.out.printf("%d ", member);
            }
            System.out.println();
        }
    }

    private static void printStudent(TreeMap<Integer, Integer> studentMap) {
        for (Map.Entry<Integer, Integer> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}