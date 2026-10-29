class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 누적된 배달/수거해야 할 상자 수 (마이너스는 남는 용량을 의미)
        int deliverCapacity = 0;
        int pickupCapacity = 0;
        
        // 가장 먼 집(n-1)부터 거꾸로 순회
        for (int i = n - 1; i >= 0; i--) {
            deliverCapacity += deliveries[i];
            pickupCapacity += pickups[i];
            
            // 현재 집에 처리해야 할 배달이나 수거가 남아있다면 왕복해야 함
            while (deliverCapacity > 0 || pickupCapacity > 0) {
                // 한 번 왕복할 때마다 cap만큼 용량이 확보됨
                deliverCapacity -= cap;
                pickupCapacity -= cap;
                
                // (집의 위치 i + 1) * 2 만큼의 왕복 거리를 누적
                answer += (i + 1) * 2L;
            }
        }
        
        return answer;
    }
}