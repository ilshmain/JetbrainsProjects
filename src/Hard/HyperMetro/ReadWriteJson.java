package Hard.HyperMetro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ReadWriteJson {
    static public ArrayList<LinesMetro> initDoubleLinked(String path) throws IOException {
        ArrayList<LinesMetro> lines = new ArrayList<>();
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileInputStream files = new FileInputStream(path);
            Reader rd = new InputStreamReader(files);
            Type type = new TypeToken<Map<String, TreeMap<Integer, Station>>>(){}.getType();
            Map<String, TreeMap<Integer, Station>> myMap = gson.fromJson(rd, type);
            for (Map.Entry<String, TreeMap<Integer, Station>> entry : myMap.entrySet()) {

                MyList lst = new MyList();

                for (Map.Entry<Integer, Station> entrySet : (entry.getValue()).entrySet()) {

                    lst.addBack(entrySet.getValue().name, entrySet.getValue().transfer);

                }
                LinesMetro line = new LinesMetro(entry.getKey(), lst);
                lines.add(line);
            }
            return lines;
        } catch (Exception ex) {
            System.out.println("Error! Incorrect data");
        }
        return null;
    }
}