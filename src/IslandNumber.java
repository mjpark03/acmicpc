import java.util.Scanner;

/**
 * Created by Rachel on 2016. 8. 28..
 */
public class IslandNumber {

    static final int MAX = 51;

    static int[][] map = new int[MAX][MAX];
    static int[][] visited = new int[MAX][MAX];

    static int w, h;

    public static void main(String[] args) {
        int count = 0;

        Scanner scan = new Scanner(System.in);

        while(true) {

            count = 0;
            String xyLine = scan.nextLine();
            w = Integer.parseInt(xyLine.split(" ")[0]);
            h = Integer.parseInt(xyLine.split(" ")[1]);

            if( w == 0 && h == 0 )
                break;

            for(int i=1; i<=w; i++) {
                for(int j=1; j<=h; j++) {
                    visited[i][j] = 0;
                    map[i][j] = 0;
                }
            }

            for(int i=1; i<=h; i++) {
                String mapLine = scan.nextLine();
                String[] mapParsing = mapLine.split(" ");

                for(int j=1; j<=w; j++) {
                    map[j][i] = Integer.parseInt(mapParsing[j-1]);
                    System.out.println("map j: " + j + ", i: " + i + ", value: " + map[j][i]);
                }
            }

            for(int i=1; i<=w; i++) {
                for (int j=1; j<=h; j++) {

                    if (visited[i][j] == 0 && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {

        visited[x][y] = 1;

        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(x+i>=1 && x+i<=w && y+j>=1 && y+j<=h) {
                    if(visited[x+i][y+j] == 0 && map[x+i][y+j] == 1) {
                        dfs(x+i, y+j);
                    }
                }
            }
        }
    }
}
