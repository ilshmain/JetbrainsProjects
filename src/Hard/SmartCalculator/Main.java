package Hard.SmartCalculator;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static boolean command (String str) {
        boolean result;

        result = true;
        if (str.equals("/exit")) {
            result = false;
        } else if (str.equals("/help")) {
            System.out.println("The program calculates the sum of numbers");
        } else {
            System.out.println("Unknown command");
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, BigInteger> map = new HashMap<>();
        String str;

        for (;;) {
            str = scanner.nextLine();
            if (str.equals("")) continue;

            if (str.charAt(0) == '/') {
                if (!command(str)) {
                    System.out.println("Bye!");
                    return;
                }
            } else {
                SolutionExpression.solutionExpression(str, map);
            }
        }
    }
}
