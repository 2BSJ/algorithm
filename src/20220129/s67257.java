import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class s67257 {

    List<Integer> numList = new ArrayList<>();
    List<String> expList = new ArrayList<>();
    Set<String> expSet = new HashSet<>();

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
     */
    public static void main(String[] args) {
        s67257 problem = new s67257();
        String expression = "100-200*300-500+20";
        System.out.println(problem.solution(expression));
    }

    public long solution(String expression) {
        String[] nums = expression.split("[-*+]");
        String[] exps = expression.split("[0-9]{1,}");
        for(String num : nums) {
            numList.add(Integer.parseInt(num));
        }

        for(int i=1; i<exps.length; i++) {
            expList.add(exps[i]);
            expSet.add(exps[i]);
        }

        String[] setArray = expSet.toArray(new String[]{});
        permutation(setArray,0, setArray.length, setArray.length);

        long answer = 0;
        return answer;
    }

    public void permutation(String[] exps, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++){

            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(exps, depth, i);
            permutation(exps, depth + 1, n, r);
            swap(exps, depth, i);
        }
    }

    public void swap(String[] exps, int depth, int i) {
        String temp = exps[depth];
        exps[depth] = exps[i];
        exps[i] = temp;
    }
}
