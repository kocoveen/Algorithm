import java.lang.Math;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] L = {0, 3};
        int[] R = {2, 3};
        int[][] coord = new int[12][2];
        
        for (int i=0; i<12; i++) {
            if (i == 0 || i > 9) {
                coord[i][1] = 3;
                switch (i) {
                    case 0:
                        coord[i][0] = 1;
                        break;
                    case 10: 
                        coord[i][0] = 0;
                        break;
                    case 11: 
                        coord[i][0] = 2;
                        break;
                }
            } else if (i > 0 && i < 10) {
                coord[i][0] = (i+2) % 3;
                coord[i][1] = (i-1) / 3;
            }
        }
        
        for (int num : numbers) {
            if(num % 3 == 1) {
                L[0] = coord[num][0];
                L[1] = coord[num][1];
                answer += "L";
            } else if (num % 3 == 0 && num != 0) {
                R[0] = coord[num][0];
                R[1] = coord[num][1];
                answer += "R";
            } else {
                if (Math.abs(L[0]-coord[num][0]) + Math.abs(L[1]-coord[num][1]) > Math.abs(R[0]-coord[num][0]) + Math.abs(R[1]-coord[num][1])) {
                    R[0] = coord[num][0];
                    R[1] = coord[num][1];
                    answer += "R";
                } else if (Math.abs(L[0]-coord[num][0]) + Math.abs(L[1]-coord[num][1]) < Math.abs(R[0]-coord[num][0]) + Math.abs(R[1]-coord[num][1])) {
                    L[0] = coord[num][0];
                    L[1] = coord[num][1];
                    answer += "L";
                } else {
                    switch (hand) {
                        case "left":
                            L[0] = coord[num][0];
                            L[1] = coord[num][1];
                            answer += "L";
                            break;
                        case "right":
                            R[0] = coord[num][0];
                            R[1] = coord[num][1];
                            answer += "R";
                            break;
                    }
                }

            }
        }
        
        return answer;
    }
}