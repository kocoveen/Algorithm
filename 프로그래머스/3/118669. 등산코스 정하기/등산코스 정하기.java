import java.util.*;

class Solution {
    // 그래프 표현을 위한 인접 리스트
    static List<List<Node>> graph;
    
    // 최소 산봉우리 번호와 최소 intensity를 저장하는 변수
    static int minSummit = Integer.MAX_VALUE;
    static int minIntensity = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 그래프 초기화
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        makeGraph(paths);
        findPath(n, gates, summits);
        return new int[]{minSummit, minIntensity};
    }

    // 양방향 그래프 생성
    private static void makeGraph(int[][] paths) {
        for (int[] path : paths) {
            int v1 = path[0], v2 = path[1], cost = path[2];
            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }
    }

    // 최적 경로 탐색
    private static void findPath(int n, int[] gates, int[] summits) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        // intensities 배열: 각 정점까지의 최소 intensity를 저장
        int[] intensities = new int[n + 1]; // 인덱스는 정점 번호, 값은 해당 정점까지의 최소 intensity
        
        Arrays.fill(intensities, Integer.MAX_VALUE);
        Set<Integer> summitSet = new HashSet<>();

        for (int summit : summits) {
            summitSet.add(summit);
        }

        // 출발점의 intensity를 0으로 초기화
        for (int gate : gates) {
            queue.offer(new Node(gate, 0));
            intensities[gate] = 0;
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.intensity > minIntensity) continue;

            if (summitSet.contains(current.vertex)) {
                updateMinimum(current.vertex, current.intensity);
                continue;
            }

            for (Node next : graph.get(current.vertex)) {
                // 현재까지의 intensity와 다음 경로의 intensity 중 큰 값을 선택
                int newIntensity = Math.max(current.intensity, next.intensity);
                
                // 만약 새로운 intensity가 기존에 저장된 값보다 작다면 업데이트
                if (intensities[next.vertex] > newIntensity) {
                    intensities[next.vertex] = newIntensity;
                    queue.offer(new Node(next.vertex, newIntensity));
                }
            }
        }
    }

    // 최소 산봉우리와 intensity 업데이트
    private static void updateMinimum(int summit, int intensity) {
        // intensity가 작거나, 같지만 산봉우리가 작은 경우
        if (intensity < minIntensity || (intensity == minIntensity && summit < minSummit)) {
            minIntensity = intensity;
            minSummit = summit;
        }
    }
}

// 노드 클래스 정의
class Node implements Comparable<Node> {
    int vertex;
    int intensity;

    Node(int vertex, int intensity) {
        this.vertex = vertex;
        this.intensity = intensity;
    }

    @Override
    public int compareTo(Node other) {
        if (this.intensity != other.intensity) return Integer.compare(this.intensity, other.intensity);
        return Integer.compare(this.vertex, other.vertex);
    }
}