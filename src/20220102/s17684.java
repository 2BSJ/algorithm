import java.util.HashMap;
import java.util.LinkedList;

public class s17684 {

    public static void main(String[] args) {
        s17684 problem = new s17684();
        System.out.println(problem.solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    public int[] solution(String msg) {
        LinkedList<Integer> answerList = new LinkedList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();
        for(int i='A'; i<='Z'; i++) {
            dictionary.put(Character.toString((char)i), i-64);
        }
        boolean end = false;
        for(int i=0; i<msg.length(); i++) {

            String w = Character.toString(msg.charAt(i));
            String c = "";
            if(i != msg.length()-1) {
                c = Character.toString(msg.charAt(i + 1));
            }
            String wc = w+c;
            int cCount = i+2;
            while(true) {
                if(end) {
                    break;
                }
                if (dictionary.get(wc) == null) {
                    dictionary.put(wc, dictionary.size()+1);
                    answerList.add(dictionary.get(w));
                    break;
                } else {
                    if(cCount > msg.length()-1) {
                        end = true;
                        answerList.add(dictionary.get(wc));
                        break;
                    }
                    w = wc;
                    c = Character.toString(msg.charAt(cCount));
                    wc = w + c;
                    cCount++;
                    i++;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
