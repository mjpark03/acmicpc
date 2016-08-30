import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Rachel on 2016. 8. 29..
 */
public class MazeSearch {

    public static void main(String[] args) {

        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Scanner scan = new Scanner(System.in);
        String nmLine = scan.nextLine();
        int n = Integer.parseInt(nmLine.split(" ")[0]);
        int m = Integer.parseInt(nmLine.split(" ")[1]);

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        ArrayDeque<Point> queue = new ArrayDeque<Point>();

        for(int i=0; i<n; i++) {
            String mapLine = scan.nextLine();
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(mapLine.substring(j,j+1));
            }
        }

        Point p = new Point(0,0);
        queue.offer(p);
        visited[p.x][p.y] = 1;

        while(!queue.isEmpty()) {
            Point front = queue.pollFirst();

            if(front.x-1>=0 && map[front.x-1][front.y]==1 && visited[front.x-1][front.y]==0) {
                Point next = new Point(front.x-1, front.y);
                queue.offer(next);
                visited[front.x-1][front.y] += visited[front.x][front.y] + 1;
            }

            if(front.x+1<n && map[front.x+1][front.y]==1 && visited[front.x+1][front.y]==0) {
                Point next = new Point(front.x+1, front.y);
                queue.offer(next);
                visited[front.x+1][front.y] += visited[front.x][front.y] + 1;
            }

            if(front.y-1>=0 && map[front.x][front.y-1]==1 && visited[front.x][front.y-1]==0) {
                Point next = new Point(front.x, front.y-1);
                queue.offer(next);
                visited[front.x][front.y-1] += visited[front.x][front.y] + 1;
            }

            if(front.y+1<m && map[front.x][front.y+1]==1 && visited[front.x][front.y+1]==0) {
                Point next = new Point(front.x, front.y+1);
                queue.offer(next);
                visited[front.x][front.y+1] += visited[front.x][front.y] + 1;
            }
        }

        System.out.println("" + visited[n-1][m-1]);
    }
}
