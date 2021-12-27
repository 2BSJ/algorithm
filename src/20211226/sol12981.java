import java.util.ArrayList;

public class sol12981 {
    public static void main(String[] args) {
        sol12981 problem = new sol12981();
        String[] words = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(problem.solution(3, words));
    }

    public int[] solution(int n, String[] words) {

        ArrayList<String> answerList = new ArrayList<>();
        int answer1 = 0;
        int answer2 = 0;

        answerList.add(words[0]);
        for(int i=1; i<words.length; i++) {
            if(answerList.contains(words[i])) {
                answer1 = i%n + 1;
                answer2 = i/n + 1;
                break;
            }
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                answer1 = i%n + 1;
                answer2 = i/n + 1;
                break;
            } else{
                answerList.add(words[i]);
            }
        }

        return new int[]{answer1, answer2};
    }
}
