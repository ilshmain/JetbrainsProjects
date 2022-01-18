package Hard.SmartCalculator;

import java.math.BigInteger;
import java.util.Map;
import java.util.regex.Pattern;

public class SolutionExpression {

    public static void solutionExpression(String str, Map<String, BigInteger> map) {
        String result;

        result = ChangeInputStr.deleteEntraCharacters(str);

        Pattern patternMulti = Pattern.compile((".*\\*{2,}.*"));
        Pattern patternDevision= Pattern.compile((".*/{2,}.*"));
        if (patternMulti.matcher(result).matches() || patternDevision.matcher(result).matches()) {
            System.out.println("Invalid identifier");
            return ;
        }

        Pattern expression = Pattern.compile("[a-zA-Z0-9()/*+-]*");
        if (expression.matcher(result).matches()) {
            if (!AddKeyAndValue.checkKey(result, map))
                ReversePolishNotation.inversePolishRecord(map, result);
            return;
        }

        Pattern checkleftSide = Pattern.compile("[a-zA-Z+-]*\\s*=.*");
        if (!checkleftSide.matcher(result).matches()) {
            System.out.println("Invalid identifier");
            return ;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z]*\\s*=\\s*([-+0-9()]*|[A-Za-z()]*)\\s*");
        if (!pattern.matcher(result).matches()) {
            System.out.println("Invalid assignment");
            return ;
        }
        AddKeyAndValue.addKeyAndValue(map, result);
    }
}
