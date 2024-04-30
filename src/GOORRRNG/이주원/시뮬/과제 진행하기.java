import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Task[] tasks = new Task[plans.length];
        int answerIndex = 0;
        for(int i = 0; i < plans.length; i++) {
            String[] times = plans[i][1].split(":");
            Task t = new Task();
            t.subject = plans[i][0];
            t.start = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            t.duration = Integer.parseInt(plans[i][2]);
            tasks[i] = t;
        }
        Arrays.sort(tasks, (o1, o2) -> o1.start - o2.start);
        ArrayDeque<Task> stack = new ArrayDeque<>();
        
        for(int i = 0; i < tasks.length-1; i++) {
            stack.push(tasks[i]);
            int remain = tasks[i+1].start - tasks[i].start;
                while(!stack.isEmpty() && remain > 0) {
                    Task task = stack.pop();
                    if(remain >= task.duration) {
                        answer[answerIndex++] = task.subject;
                        remain -= task.duration;
                    } else {
                        task.duration -= remain;
                        stack.push(task);
                        remain = 0;
                    }
                }
        }
        stack.push(tasks[tasks.length-1]);
        while(!stack.isEmpty()) {
            answer[answerIndex++] = stack.pop().subject;
        }
        return answer;
    }

    static class Task {
        String subject;
        int start;
        int duration;
    }
}