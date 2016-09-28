import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 24..
 */
public class BlockNumber {

    static final int MAX = 26;
    static int[][] map = new int[MAX][MAX];
    static int[][] visited = new int[MAX][MAX];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for(int y=1; y<=n; y++) {
            int x = 1;
            String line = scan.nextLine();

            for(int i=0; i<line.length(); i++) {
                map[y][x++] = Integer.parseInt("" + line.charAt(i));
            }
        }

        List<Integer> countList = new ArrayList<>();
        int totalCount = 0;
        for(int y=1; y<=n; y++) {
            for(int x=1; x<=n; x++) {
                if(visited[y][x]==0 && map[y][x]==1) {
                    int count = dfs(y, x, 0, n);
                    dfs(y, x, 1, n);
                    countList.add(count);

                    totalCount++;
                }
            }
        }

        Integer[] countArr = new Integer[countList.size()];
        countArr = countList.toArray(countArr);
        Arrays.sort(countArr);

        System.out.println(totalCount);
        for(Integer count: countArr) {
            System.out.println(count);
        }
    }

    public static int dfs(int y, int x, int count, int n) {
        visited[y][x] = 1;
        count++;

        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(y+i>=1 && y+i<=n && x+j>=1 && x+j<=n) {
                    if(visited[y+i][x]==0 && map[y+i][x]==1) {
                        count = dfs(y+i, x, count, n);
                    }
                    if(visited[y][x+j]==0 && map[y][x+j]==1) {
                        count = dfs(y, x+j, count, n);
                    }
                }
            }
        }

        return count;
    }
}
