class Solution {
    public int solution(String my_string) {
	    int answer = 0;
        String str = my_string;
        String[] results = str.split("[a-zA-Z]");
        for (String a : results) {
        	if (a.equals("")) {continue;}
        	answer += Integer.parseInt(a);
        }
        return answer;
    }
}