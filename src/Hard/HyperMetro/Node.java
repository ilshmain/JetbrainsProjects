package Hard.HyperMetro;

import java.util.List;

public class Node {
    public String str;
    public List<Transfer> transfer;
    public Node next;
    public Node previous;

    public Node (String str, List<Transfer> transfer) {
        this.str = str;
        this.transfer = transfer;
    }
}
