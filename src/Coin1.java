import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 17..
 */
public class Coin1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        int n = Integer.parseInt(inputLine.split(" ")[0]);
        int k = Integer.parseInt(inputLine.split(" ")[1]);

        int[] coins = new int[n];
        int[] cache = new int[10001];

        for(int i=0; i<n; i++) {
            int coin = scan.nextInt();
            coins[i] = coin;
        }

        cache[0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=1; j<=k; j++) {
                if(j >= coins[i])
                    cache[j] += cache[j-coins[i]];
            }
        }

        System.out.println("" + cache[k]);
    }
}
