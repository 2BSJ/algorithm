public class s42860 {
    public static void main(String[] args) {
        s42860 problem = new s42860();
        String name = "AAAAAAABA";
        System.out.println(problem.solution(name));
    }

    public int solution(String name) {
        int updown = 0;
        int leftright = Integer.MAX_VALUE;
        for(int i=0; i<name.length(); i++) {
            char alphabet = name.charAt(i);
            if(alphabet > 'M') {
                updown += 'Z' - alphabet + 1;
            } else {
                updown += alphabet - 'A';
            }

            int end = i+1;
            while(end<name.length() && name.charAt(end)=='A'){
                end++;
            }
            leftright = Math.min(leftright, i*2+(name.length()-end));
        }
        return updown + leftright;
    }
}