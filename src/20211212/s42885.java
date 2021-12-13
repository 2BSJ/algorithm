import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s42885 {
    /**
     * people[] = 1 ~ 50000
     * limit = 40 ~ 240
     * each people weight = 40 ~ 240
     * limit은 people배열의 최댓값보다 항상 큼
     */
    public static void main(String[] args) {
        s42885 problem = new s42885();
        int[] people = {70,50,80,50};
        int limit = 100;
        problem.solution(people,limit);
    }

    /**
     * 인터넷 풀이
     */
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }

    /**
     *
     * 내 풀이
     */
    public int solution1(int[] people, int limit) {
        int answer = 0;
        int tempAnswer = 0;
        Arrays.sort(people);
        List<Integer> peopleList = new ArrayList<>();
        for(int i=0; i<people.length; i++) {
            peopleList.add(people[i]);
        }

        for(int i=0; i<=peopleList.size(); i++) {
            if(tempAnswer == peopleList.size()) {
                return answer;
            }
            if(peopleList.get(i) + peopleList.get(peopleList.size()-answer-1) <= limit) {
                answer++;
                tempAnswer += 2;
            } else {
                if(i>0) {
                    i--;
                }
                tempAnswer++;
                answer++;
            }
        }
        return answer;
    }
}