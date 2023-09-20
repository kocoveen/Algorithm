class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 카운트 배열 생성
        long[] cntWeight = new long[1001];  // 몸무게 원본 저장
        long[] cntMul = new long[4001];     // 몸무게 배수 저장

        // weights 배열 순회
        for(int i = 0; i < weights.length; i ++) {
            // 현재 사람의 몸무게 체크
            long temp = cntWeight[weights[i]];
            int m2 = weights[i] * 2;
            int m3 = weights[i] * 3;
            int m4 = weights[i] * 4;
            if(temp > 0) { // 앞에서 같은 몸무게가 있었다면
                // 그 사람 수 만큼 카운트 ++
                answer += temp;
                // 몸무게 2, 3, 4배 체크하기
                answer += cntMul[m2] - temp;
                answer += cntMul[m3] - temp;
                answer += cntMul[m4] - temp;
            } else {                        // 앞에서 같은 몸무게가 없었다면
                answer += cntMul[m2];
                answer += cntMul[m3];
                answer += cntMul[m4];
            }

            // 배열에 카운트 더하기
            cntWeight[weights[i]] ++;
            cntMul[m2] ++;
            cntMul[m3] ++;
            cntMul[m4] ++;
        }

        return answer;
    }
}