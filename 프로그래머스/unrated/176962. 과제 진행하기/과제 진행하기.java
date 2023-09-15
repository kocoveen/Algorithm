import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[][] plans) {
        Queue<Plan> todoList = Arrays.stream(plans)
                .map(plan -> new Plan(plan[0], plan[1], plan[2]))
                .sorted(Comparator.comparingInt(p -> p.start))
                .collect(Collectors.toCollection(LinkedList::new));

        Queue<Plan> working = new LinkedList<>();

        Stack<Plan> remainList = new Stack<>();

        List<Plan> complete = new ArrayList<>();

        while (!todoList.isEmpty()) {
            if (working.isEmpty()) {
                working.add(todoList.poll());
                continue;
            }

            Plan curPlan = working.poll();
            Plan nextPlan = todoList.peek();

            int workedTime = nextPlan.start - curPlan.start;
            int remainWorkTime = curPlan.playtime - workedTime;

            if (remainWorkTime > 0) {
                curPlan.playtime = remainWorkTime;
                remainList.push(curPlan);

            } else {
                curPlan.playtime = remainWorkTime;
                complete.add(curPlan);

                while (!remainList.isEmpty()) {
                    Plan remainPlan = remainList.pop();
                    remainWorkTime += remainPlan.playtime;
                    if (remainWorkTime > 0) {
                        remainPlan.playtime = remainWorkTime;
                        remainList.push(remainPlan);
                        break;

                    } else {
                        remainPlan.playtime = 0;
                        complete.add(remainPlan);
                    }
                }
            }
        }

        complete.add(working.poll());

        while (!remainList.isEmpty()) {
            complete.add(remainList.pop());
        }

        String[] answer = new String[complete.size()];
        for (int i = 0; i < complete.size(); i++) {
            answer[i] = complete.get(i).name;
            System.out.printf("[%s]", answer[i]);
        }

        return answer;
    }

    static class Plan {
        String name;
        int start;
        int playtime;

        public Plan(String name, String start, String playtime) {
            this.name = name;
            this.start = timeToDigit(start);
            this.playtime = Integer.parseInt(playtime);
        }

        private int timeToDigit(String time) {
            String[] timeSplit = time.split(":");
            return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
        }
    }
}