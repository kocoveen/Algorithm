import java.util.*;

class Solution {

    TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

    public int solution(int n, int k, int[] enemy) {


        int i, size = 0;
        for (i = 0; i < enemy.length; i++) {

            map.computeIfAbsent(enemy[i], key -> new TreeSet<>()).add(i);
            size++;

            if (size > k) {
                int enemySize = map.firstKey();
                if (map.get(enemySize).size() == 1) {
                    map.remove(enemySize);
                } else {
                    map.get(enemySize).pollLast();
                }
                n -= enemySize;

                if (n < 0) {
                    break;
                }
            }
        }

//        for (Map.Entry<Integer, TreeSet<Integer>> en : map.entrySet()) {
//            System.out.printf("%d : ", en.getKey());
//            for (Integer i : en.getValue()) {
//                System.out.printf("[%d]", i);
//            }
//            System.out.println();
//        }

        return i;
    }
}