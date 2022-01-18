package Hard.HyperMetro;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPathInput {
    static public  String[] checkInputLine(String input) {
        String[] mas  = new String[5];
        ArrayList<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".*?\")\\s*").matcher(input);

        int i = 0;
        while (m.find())
            list.add(m.group(1).replaceAll("\"", ""));
        for (String elem: list) {
            mas[i] = elem;
            i++;
        }

        return mas;
    }

    static public Boolean checkFormatAndPathFile(String path) {
        Path filePath= Paths.get(path);
        String regex = ".*.json";

        if (!Files.exists(filePath))  {
            System.out.println("Error! Such a file doesn't exist!");
            return false;
        }

        if (!path.matches(regex)) {
            System.out.println("Incorrect file");
            return false;
        }
        return true;
    }
}

