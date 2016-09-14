import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rachel on 2016. 9. 14..
 */
public class ATM {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleNum = Integer.parseInt(scan.nextLine());
        int[] times = new int[peopleNum];

        String timesStr = scan.nextLine();
        int index = 0;
        for(String timeStr : timesStr.split(" ")) {
            times[index++] = Integer.parseInt(timeStr);
        }

        Arrays.sort(times);
        int result = 0;
        int accTimes = 0;
        for(int time : times) {
            accTimes += time;
            result += accTimes;
        }

        System.out.println("" + result);
    }
}
