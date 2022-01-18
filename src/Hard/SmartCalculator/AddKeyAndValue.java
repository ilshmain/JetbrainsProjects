package Hard.SmartCalculator;

import java.math.BigInteger;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class AddKeyAndValue {
    public static void addKeyAndValue(Map<String, BigInteger> map, String str) {
        Pattern pattern = Pattern.compile("[A-Za-z]*=[-+0-9A-Za-z]*");
        String[] mas = str.split("=");
        BigInteger value;

        try {
            if (pattern.matcher(str).matches()) {
                value = new BigInteger(mas[1]);
                map.put(mas[0], value);
            } else {
                value = map.get(mas[1]);
                if (value == null) {
                    System.out.println("Unknown variable");
                } else {
                    map.put(mas[0], value);
                }
            }
        } catch (NumberFormatException e) {
            if (map.get(mas[1]) == null) {
                System.out.println("Unknown variable");
            } else {
                map.put(mas[0], map.get(mas[1]));
            }
        }
    }

    public static boolean checkKey(String str, Map<String, BigInteger> map) {
        BigInteger strBigInt;
        int i;
        BigInteger value;
        StringTokenizer itsKey = new StringTokenizer(str, "+-()*/");

        i = 0;
        while (itsKey.hasMoreTokens()) {
            itsKey.nextToken();
            i++;
        }
        if (i == 1) {
            try {
                value = map.get(str);
                if (value == null) {
                    System.out.println("Unknown variable");
                } else {
                    System.out.println(value);
                }
            } catch (NullPointerException e) {
                try {
                    strBigInt = new BigInteger(str);
                    value = strBigInt;
                    System.out.println(value);
                } catch (NumberFormatException e1) {
                    System.out.println("Unknown variable");
                }
            }
            return true;
        }
        return false;
    }
}
