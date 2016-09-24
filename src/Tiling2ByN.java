import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 23..
 */
public class Tiling2ByN {

    static int[] cache = new int[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i<=n; i++) {
            int count = cache[i-1] + cache[i-2];
            if(count > 10007)
                count = count % 10007;

            cache[i] = count;
        }

        System.out.println("" + cache[n]);
    }
}
