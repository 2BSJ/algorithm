import java.util.Arrays;

public class s84512 {
    public static void main(String[] args) {
        s84512 problem = new s84512();
        System.out.println(problem.solution("AAAAE"));
    }

    public int solution(String word) {
        int answer = 0;
        int[] add = {781, 156, 31, 6, 1};
        Character[] wordCharArray = {'A','E','I','O','U'};

        for(int i=0; i<word.length(); i++) {
            answer += Arrays.asList(wordCharArray).indexOf(word.charAt(i)) * add[i] + 1;
        }

        return answer;
    }
}
