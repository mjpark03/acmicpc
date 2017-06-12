import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Rachel on 2017. 6. 13..
 */
public class StartLink {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] inputs = scan.nextLine().split(" ");

        int f = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);
        int g = Integer.parseInt(inputs[2]);
        int u = Integer.parseInt(inputs[3]);
        int d = Integer.parseInt(inputs[4]);

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[f+1];

        queue.offer(s);
        visited[s] = 1;

        while(!queue.isEmpty()) {
            int p = queue.pollFirst();

            if(p+u >= 1 && p+u <= f && visited[p+u] == 0) {
                visited[p+u] = visited[p] + 1;

                if(p+u == g) {
                    break;
                }

                queue.offer(p+u);
            }

            if(p-d >= 1 && p-d <= f && visited[p-d] == 0) {
                visited[p-d] = visited[p] + 1;

                if(p-d == g) {
                    break;
                }

                queue.offer(p-d);
            }
        }

        int count = visited[g]-1;
        if(count == -1)
            System.out.println("use the stairs");
        else
            System.out.println(count);
    }
}
