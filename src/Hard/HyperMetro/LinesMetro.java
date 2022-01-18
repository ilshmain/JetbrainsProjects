package Hard.HyperMetro;

import java.util.ArrayList;
import java.util.List;

public class LinesMetro {
    public String lineName;
    public MyList lst;

    public LinesMetro(String lineName, MyList lst) {
        this.lineName = lineName;
        this.lst = lst;
    }

    static public void addStationBack(String nameMetroLine, String stationName, ArrayList<LinesMetro> lines, java.util.List<Transfer> transfer) {
        for (LinesMetro metroLine : lines) {
            if (metroLine.lineName.equals(nameMetroLine)) {
                metroLine.lst.addBack(stationName, transfer);
            }
        }
    }

    static public void addStationFront(String nameMetroLine, String stationName, ArrayList<LinesMetro> lines, List<Transfer> transfer) {
        for (LinesMetro metroLine : lines) {
            if (metroLine.lineName.equals(nameMetroLine)) {
                metroLine.lst.addFront(stationName, transfer);
            }
        }
    }

    static public void removeStation(String nameMetroLine, String stationName, ArrayList<LinesMetro> lines) {
        for (LinesMetro metroLine : lines) {
            if (metroLine.lineName.equals(nameMetroLine)) {
                metroLine.lst.remove(stationName);
            }
        }
    }

    static public void printStations(String nameMetroLine, ArrayList<LinesMetro> lines) {
        for (LinesMetro metroLine : lines) {
            if (metroLine.lineName.equals(nameMetroLine)) {
                metroLine.lst.printList();
            }
        }
    }

    static public void connectStations(String nameMetroLine, String station, String line2, String station2, ArrayList<LinesMetro> lines) {
        for (LinesMetro metroLine : lines) {
            if (metroLine.lineName.equals(nameMetroLine)) {
                metroLine.lst.connect(station, line2, station2);
            } else if (metroLine.lineName.equals(line2)) {
                metroLine.lst.connect(station2, nameMetroLine, station);
            }
        }
    }
}
