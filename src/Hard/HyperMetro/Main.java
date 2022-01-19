package Hard.HyperMetro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static public boolean check(String path) {
        if (!CheckPathInput.checkFormatAndPathFile(path)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Missing file path");
            return;
        }
        String[] mas;
        ArrayList<LinesMetro> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        lines = ReadWriteJson.initDoubleLinked(args[0]);
        for (;;) {
            String input = scanner.nextLine();
            mas = CheckPathInput.checkInputLine(input);
            if (mas[0].equals("/append")) {
                LinesMetro.addStationBack(mas[1], mas[2], lines, null);
            } else if (mas[0].equals("/add-head")) {
                LinesMetro.addStationFront(mas[1], mas[2], lines, null);
            } else if (mas[0].equals("/remove")) {
                LinesMetro.removeStation(mas[1], mas[2], lines);
            } else if (mas[0].equals("/output")){
                LinesMetro.printStations(mas[1], lines);
            } else if (mas[0].equals("/connect")) {
                LinesMetro.connectStations(mas[1], mas[2], mas[3], mas[4], lines);
            } else if (mas[0].equals("/exit")) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}