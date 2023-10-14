import java.util.*;

class Solution {
    Map<String, Integer> portMap = new HashMap<>();
    Map<Integer, String> indexMap = new HashMap<>();
    int[][] count;
    List<String[]> paths = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        int i = 0;
        for (String[] ticket : tickets) {
            for (String port : ticket) {
                if (!portMap.containsKey(port)) {
                    portMap.put(port, i);
                    indexMap.put(i, port);
                    i++;
                }
            }
        }

//         for (Map.Entry<String, Integer> en : portMap.entrySet()) {
//             System.out.println(en.getKey() + " " + en.getValue());
//         }
//
//         for (Map.Entry<Integer, String> en : indexMap.entrySet()) {
//             System.out.println(en.getKey() + " " + en.getValue());
//         }

        int c = portMap.size();
        count = new int[c][c];

        for (String[] ticket : tickets) {
            count[portMap.get(ticket[0])][portMap.get(ticket[1])]++;
        }


        int[] path = new int[tickets.length + 1];
        Arrays.fill(path, -1);

        func(portMap.get("ICN"), path, 0);

        paths.sort((p1, p2) -> {
            int p = 0;
            for (; p < p1.length; p++) {
                if (!p1[p].equals(p2[p])) break;
            }
            return p1[p].compareTo(p2[p]);
        });

        return paths.get(0);
    }

    public void func(int fromIdx, int[] path, int depth) {
        if (depth == path.length - 1) {
            path[depth] = fromIdx;
            String[] tmp = new String[path.length];
            for (int i = 0; i < path.length; i++) {
                tmp[i] = indexMap.get(path[i]);
            }

            paths.add(tmp);
            return;
        }

        for (int toIdx = 0; toIdx < count.length; toIdx++) {
            if (count[fromIdx][toIdx] > 0) {
                count[fromIdx][toIdx]--;
                path[depth] = fromIdx;
                func(toIdx, path, depth + 1);
                path[depth] = -1;
                count[fromIdx][toIdx]++;
            }
        }
    }

}