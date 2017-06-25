import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Rachel on 2017. 6. 29..
 */
public class NewEmployee {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while( t > 0 ) {
            int n = scan.nextInt();
            HashMap<Integer, Integer> rank = new HashMap<>();

            for(int i = 0; i < n; i++) {
                rank.put(scan.nextInt(), scan.nextInt());
            }

            int count = 1;
            int max = rank.get(1);

            for(int i = 2; i <= n; i++ ) {
                int second = rank.get(i);
                if(max > second) {
                    count++;
                    max = second;
                }
            }

            System.out.println(count);
            t--;
        }
    }
}
