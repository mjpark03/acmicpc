import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Rachel on 2016. 9. 12..
 */
public class IronStick {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int count = 0;
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<input.length(); i++) {
            char bracket = input.charAt(i);

            if(bracket == ')') {
                stack.pop();

                if(input.charAt(i-1) == '(')
                    count += stack.size();
                else
                    count += 1;

            } else {
                stack.push(bracket);
            }
        }

        System.out.println("" + count);
    }
}
