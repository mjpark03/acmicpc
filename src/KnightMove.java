import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Rachel on 2017. 6. 7..
 */

public class KnightMove {

    public static void main(String[] args) {

        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] rangeX = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] rangeY = {-1, 1, 2, -2, -2, 2, -1, 1};

        ArrayDeque<Point> queue = new ArrayDeque<Point>();

        Scanner scan = new Scanner(System.in);
        int caseCount = Integer.parseInt(scan.nextLine());

        while(caseCount != 0) {

            int n = Integer.parseInt(scan.nextLine());
            String[] xy = scan.nextLine().split(" ");
            String[] uv = scan.nextLine().split(" ");

            int[][] visited = new int[n][n];
            Point p = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));

            queue.offer(p);
            visited[p.x][p.y] = 1;

            while(!queue.isEmpty()) {
                Point front = queue.pollFirst();
                int x = front.x;
                int y = front.y;

                for(int i=0; i<8; i++) {
                    int tempX = x + rangeX[i];
                    int tempY = y + rangeY[i];

                    if(tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && visited[tempX][tempY] == 0) {
                        visited[tempX][tempY] = visited[x][y] + 1;
                        Point next = new Point(tempX, tempY);
                        queue.offer(next);
                    }
                }
            }

            caseCount--;
            System.out.println(visited[Integer.parseInt(uv[0])][Integer.parseInt(uv[1])]-1);
        }
    }

}
