import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 19..
 */
public class Coin2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        int n = Integer.parseInt(inputLine.split(" ")[0]);
        int k = Integer.parseInt(inputLine.split(" ")[1]);

        int[] coins = new int[n];
        int[] amountCache = new int[k+1];

        for(int i=0; i<n; i++) {
            int coin = scan.nextInt();
            coins[i] = coin;
        }

        for(int i=1; i<amountCache.length; i++) {
            amountCache[i] = -1;
        }

        for(int i=1; i<amountCache.length; i++) {
            for(int j=0; j<n; j++) {
                if(coins[j] <= i) {
                    int previousCount = amountCache[i-coins[j]];

                    if(previousCount != -1 && (amountCache[i] == -1 || previousCount+1 < amountCache[i]))
                        amountCache[i] = previousCount + 1;
                }
            }
        }

        System.out.println("" + amountCache[k]);
    }
}
