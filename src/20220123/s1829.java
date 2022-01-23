import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class s1829 {
    boolean[][] visit;
    Map<Integer, Integer> widthMap;
    public static void main(String[] args) {
        s1829 problem = new s1829();
        int[][] picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(problem.solution(6,4,picture));
    }

    public int[] solution(int m, int n, int[][] picture) {

        widthMap = new HashMap<>();
        visit = new boolean[m][n];
        int area = 0;

        for(int i=0;i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                if(picture[i][j] != 0) {
                    dfs(i, j, picture[i][j], picture, area);
                    area++;
                }
            }
        }

        Integer max = Collections.max(widthMap.values());
        return new int[]{widthMap.size(),max};
    }

    public void dfs(int i, int j, int color, int[][] picture, int area) {
        if(visit[i][j] || picture[i][j] != color) {
            return;
        }
        visit[i][j] = true;
        if(widthMap.containsKey(area)) {
            int mapColor = widthMap.get(area);
            widthMap.put(area, ++mapColor);
        } else {
            widthMap.put(area, 1);
        }

        if(i-1 >= 0 && !visit[i-1][j]) {
            dfs(i-1,j,picture[i][j], picture, area);
        }
        if(i+1 < picture.length && !visit[i+1][j]) {
            dfs(i+1,j,picture[i][j], picture, area);
        }
        if(j-1 >= 0 && !visit[i][j-1]) {
            dfs(i,j-1,picture[i][j], picture, area);
        }
        if(j+1 < picture[0].length && !visit[i][j+1]) {
            dfs(i,j+1,picture[i][j], picture, area);
        }
    }
}
