package Hard.SmartCalculator;

import java.util.regex.Pattern;

public class ChangeInputStr {
    public static String deleteEntraCharacters(String str) {
        Pattern patternPlusMinus = Pattern.compile("\\+{2,}|(--){1,}|\\+\\s*\\+");
        Pattern patternMinus = Pattern.compile("(-\\s*\\++){1,}| (\\++\\s*-){1,}");
        Pattern patternSpacve = Pattern.compile("\\s{1,}");

        while (patternPlusMinus.matcher(str).find() || patternMinus.matcher(str).find()) {
            str = patternPlusMinus.matcher(str).replaceAll(" + ");
            str = patternMinus.matcher(str).replaceAll(" - ");
        }
        str = patternSpacve.matcher(str).replaceAll("");
        return str;
    }
}
