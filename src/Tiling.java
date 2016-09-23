import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 23..
 */
public class Tiling {

    static final int MAX = 251;
    static BigInteger[] cache = new BigInteger[MAX];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n;

        while(scan.hasNextInt()) {
            initCache();
            n = scan.nextInt();

            BigInteger count = getCount(n);
            System.out.println("" + count);
        }
    }

    public static void initCache() {
        cache[0] = new BigInteger("1");
        cache[1] = new BigInteger("1");
        for(int i=2; i<MAX; i++)
            cache[i] = new BigInteger("0");
    }

    public static BigInteger getCount(int n) {
        if(n == 0 || n == 1) return new BigInteger("1");

        for(int i=2; i<=n; i++) {
            cache[i] = cache[i-1].add(cache[i-2].multiply(new BigInteger("2")));
        }

        return cache[n];
    }
}
