package Hard.SmartCalculator;

import java.math.BigInteger;
import java.util.*;

public class ReversePolishNotation {
    private static String symbols = "()+-/*";

    static boolean symb(String str) {
        if (symbols.contains(str)) return true;
        return false;
    }

    static int prioritet(String str) {

        if (str.equals("(") || str.equals(")")) return 1;
        if (str.equals("+") || str.equals("-")) return 2;
        if (str.equals("*") || str.equals("/")) return 3;
        return 0;
    }

    static void writeAnswer(List<String> position) {
        Deque<BigInteger> stack = new ArrayDeque<>();
        BigInteger strBigInt;
        BigInteger a;
        BigInteger b;

        for (String str : position) {
            if (str.equals("+")) {
                stack.push(stack.pop().add(stack.pop()));
            } else if (str.equals("*")) {
                stack.push(stack.pop().multiply(stack.pop()));
            } else if (str.equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b.subtract(a));
            } else if (str.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b.divide(a));
            }
            else  {
                strBigInt = new BigInteger(str);
                stack.push(strBigInt);
            }
        }
        System.out.println(stack.pop());
    }

    static boolean checkNumberBrackets(String str) {
        long one;
        long two;

        one = str.chars().filter(q -> q == '(').count();
        two = str.chars().filter(q -> q == ')').count();

        if (one != two) return false;
        return true;
    }

    static String checkKey(String str, Map<String, BigInteger> map) {
        if (map.get(str) != null) {
            str = String.valueOf(map.get(str));
        }
        return str;
    }

    public static void inversePolishRecord(Map<String, BigInteger> map, String str) {
        StringTokenizer it = new StringTokenizer(str, symbols, true);
        String value;
        List<String> position = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();


        if (!checkNumberBrackets(str)) {
            System.out.println("Invalid expression");
            return;
        }

        while (it.hasMoreTokens()) {
            value = it.nextToken();
            value = checkKey(value, map);

            if (symb(value)) {
                if (value.equals("("))  {
                    stack.push(value);
                }
                else if (value.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        position.add(stack.pop());
                        if (stack.isEmpty()) {
                            System.out.println("Invalid expression");
                        }
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && prioritet(value) <= prioritet(stack.peek())) {
                        position.add(stack.pop());
                    }
                    stack.push(value);
                }

            } else {
                position.add(value);
            }
        }
        while (!stack.isEmpty()) {
            position.add(stack.pop());
        }
        writeAnswer(position);
    }
}
