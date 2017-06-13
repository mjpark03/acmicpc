import java.util.Scanner;

/**
 * Created by Rachel on 2017. 6. 13..
 */
public class OrganicCabbage {

    static final int MAX = 50;
    static int[][] map = new int[MAX][MAX];
    static int[][] visited = new int[MAX][MAX];

    static int[] rangeX = {1, 0, -1, 0};
    static int[] rangeY = {0, 1, 0, -1};

    static int m, n;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCount = Integer.parseInt(scan.nextLine());

        while(testCount > 0) {

            String[] mnk = scan.nextLine().split(" ");
            m = Integer.parseInt(mnk[0]);
            n = Integer.parseInt(mnk[1]);
            int k = Integer.parseInt(mnk[2]);

            int count = 0;

            for(int i=0; i<MAX; i++) {
                for(int j=0; j<MAX; j++) {
                    visited[i][j] = 0;
                    map[i][j] = 0;
                }
            }

            for(int i=0; i<k; i++) {
                String[] xy = scan.nextLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                map[x][y] = 1;
            }

            for(int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {

                    if (visited[i][j] == 0 && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            testCount--;
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = 1;

        for(int i=0; i<4; i++) {
            int tempX = rangeX[i];
            int tempY = rangeY[i];

            if(x+tempX>=0 && x+tempX<m && y+tempY>=0 && y+tempY<n) {
                if(visited[x+tempX][y+tempY] == 0 && map[x+tempX][y+tempY] == 1) {
                    dfs(x+tempX, y+tempY);
                }
            }
        }
    }
}
