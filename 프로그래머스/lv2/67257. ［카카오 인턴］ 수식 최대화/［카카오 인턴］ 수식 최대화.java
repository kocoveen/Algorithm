import java.util.*;

class Solution {
    String[] op = {"*", "+", "-"};
    boolean[] visited = new boolean[3];
    static Long max = Long.MIN_VALUE;

    public long solution(String expression) {
        String[] numbers = expression.split("\\D");
        String[] oper = expression.split("\\d+");

        List<Long> operands = new ArrayList<>();
        for (String s : numbers) {
            operands.add(Long.parseLong(s));
        }

        List<String> operators = new ArrayList<>();
        for (String s : oper) {
            if (!s.isEmpty()) {
                operators.add(s);
            }
        }

        calculate(operands, operators);

        return max;
    }

    private void calculate(List<Long> operands, List<String> operators) {
        if (operators.size() == 0) {
            max = Math.max(max, Math.abs(operands.get(0)));
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            List<Long> operandsTmp = new ArrayList<>();
            List<String> opertorsTmp = new ArrayList<>();
            operandsTmp.addAll(operands);
            opertorsTmp.addAll(operators);

            for (int j = 0; j < opertorsTmp.size(); j++) {
                if (opertorsTmp.get(j).equals(op[i])) {
                    operandsTmp.add(j, operation(operandsTmp.remove(j), operandsTmp.remove(j), opertorsTmp.remove(j)));
                    j--;
                }
            }
            calculate(operandsTmp, opertorsTmp);
            visited[i] = false;
        }
    }

    private Long operation(Long op1, Long op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            default -> op1 * op2;
        };
    }
}