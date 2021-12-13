import java.util.*;

public class s42587 {
    public static void main(String[] args) {
        s42587 problem = new s42587();
        int[] priorities = {1,1,9,1,1,1};
        problem.solution(priorities,0);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriority = 0;
        Queue<Print> priorityQueue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            priorityQueue.add(new Print(priorities[i], i));
            if(priorities[i] > maxPriority) {
                maxPriority = priorities[i];
            }
        }

        while(!priorityQueue.isEmpty()) {
            Print pollPrint = priorityQueue.poll();
            Iterator<Print> iterator = priorityQueue.iterator();
            boolean flag = true;
            while(iterator.hasNext()) {
                Print iterPrint = iterator.next();
                if(iterPrint.getPriority() > pollPrint.getPriority()) {
                    flag = false;
                }
            }

            if(flag) {
                answer++;
                if(pollPrint.getIndex() == location) {
                    return answer;
                }
            } else {
                priorityQueue.add(pollPrint);
            }
        }
        return answer;
    }
}

class Print {
    int priority;
    int index;
    Print(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }

    public int getIndex() {
        return index;
    }
}