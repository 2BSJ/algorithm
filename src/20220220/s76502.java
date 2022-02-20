import java.util.Stack;

public class s76502 {
    public static void main(String[] args) {
        s76502 problem = new s76502();
        System.out.println(problem.solution("("));
    }

    public int solution(String s) {
        int answer = 0;
        if(s.length() % 2 != 0) {
            return 0;
        }
        for(int i=0; i<s.length(); i++) {
            String moveBracket = s.substring(i).concat(s.substring(0,i));
            if(checkBracket(moveBracket)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean checkBracket(String bracket) {
        Stack<Character> bracketStack = new Stack<>();
        for(int i=0; i<bracket.length(); i++) {
            char bracketChar = bracket.charAt(i);
            if(bracketChar == '[' || bracketChar == '(' || bracketChar == '{') {
                bracketStack.push(bracketChar);
            } else {
                if(bracketStack.size() == 0) {
                    return false;
                }
                char popChar = bracketStack.pop();
                char checkChar;
                if(popChar == '[') {
                    checkChar = ']';
                } else if(popChar == '{') {
                    checkChar = '}';
                } else {
                    checkChar = ')';
                }

                if(checkChar != bracketChar) return false;
            }
        }
        return true;
    }
}
