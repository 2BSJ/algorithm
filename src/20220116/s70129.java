import java.util.regex.Pattern;

public class s70129 {
    public static void main(String[] args) {
        s70129 problem = new s70129();
        System.out.println(problem.solution("110010101001"));
    }

    public int[] solution(String s) {
        int changeCount = 0;
        int removeCount = 0;

        while(!s.equals("1")) {
            changeCount++;
            int nowRemoveCount = 0;
            for(int i =0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    nowRemoveCount++;
                }
            }
            removeCount += nowRemoveCount;
            s = Integer.toBinaryString(s.length()-nowRemoveCount);
        }

        return new int[]{changeCount, removeCount};
    }
}
