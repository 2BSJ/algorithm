import java.util.*;

public class s42890 {
    ArrayList<Integer[]> pArr = new ArrayList<>();
    ArrayList<Integer[]> oArr = new ArrayList<>();

    public int solution(String[][] relation) {

        // 가능한 조합 만들기
        for (int i = 1; i <= relation[0].length; i++) {
            makecomb(new boolean[relation[0].length], 0, i, i);
        }

        Iterator<Integer[]> it = pArr.iterator();

        while (it.hasNext()) {
            Integer[] temp = it.next();

            HashSet<String> check = new HashSet<>();

            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (Integer t : temp) {
                    sb.append(relation[i][t]);
                }
                check.add(sb.toString());
            }

            if(check.size() == relation.length) {
                it = pArr.iterator();
                while(it.hasNext()) {
                    Integer[] t = it.next();
                    if(Arrays.asList(t).containsAll(Arrays.asList(temp))) {
                        for(Integer t2 : t) {
                            // System.out.print(t2);
                        }
                        // System.out.println();
                        pArr.remove(t);
                        it = pArr.iterator();
                    }
                }
                oArr.add(temp);
                it = pArr.iterator();
            }
        }
        return oArr.size();
    }

    void makecomb(boolean[] check, int start, int r, int n) {
        if (r == 0) {
            Integer[] temp = new Integer[n];
            int idx = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    temp[idx] = i;
                    idx++;
                }
            }
            pArr.add(temp);
        } else {
            for (int i = start; i < check.length; i++) {
                check[i] = true;
                makecomb(check, i + 1, r - 1, n);
                check[i] = false;
            }
        }
    }
}
