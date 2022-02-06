import java.util.ArrayDeque;
import java.util.Queue;

public class s1844 {

    static int n, m;
    static int[][] dist;
    static int[] dx = {-1, 0, 1 ,0};
    static int[] dy = {0, 1, 0, -1};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }

    public static void main(String[] args) {
        s1844 problem = new s1844();
        System.out.println(problem.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

    public int bfs(int[][] maps)
    {
        Queue<Point> q = new ArrayDeque<>();
        dist[0][0] = 1;
        q.add(new Point(0, 0));

        while(!q.isEmpty())
        {
            Point cur = q.remove();
            int x = cur.x;
            int y = cur.y;

            if(x == n-1 && y == m-1)
                return dist[n-1][m-1];

            for(int i=0; i<4; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) // 범위 초과
                    continue;
                if(maps[nx][ny]==0 || dist[nx][ny]!=0) // 벽 or 이미 방문
                    continue;

                dist[nx][ny] = dist[x][y]+1;
                q.add(new Point(nx, ny));
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];

        return bfs(maps);
    }
}
