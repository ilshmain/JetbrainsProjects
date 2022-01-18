package Hard.HyperMetro;

import java.util.List;

public class Station {
    public String name;
    public List<Transfer> transfer;

    public Station(String name) {
        this.name = name;
    }

    public Station() {};
}