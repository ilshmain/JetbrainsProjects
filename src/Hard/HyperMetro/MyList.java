package Hard.HyperMetro;

import java.util.List;

public class MyList {
    private Node head;
    private Node tail;

    public MyList() {
        this.head = new Node("depot", null);
        this.tail = new Node("depot", null);

        this.head.next = this.tail;
        this.tail.previous = this.head;
        this.tail.next = null;
    }

    public void addFront(String str, List<Transfer> transfer) {
        Node nowNode = new Node(str, transfer);
        if (head.next == tail) {
            head.next = nowNode;
            nowNode.previous = head;
            nowNode.next = tail;
            tail.previous = nowNode;
        } else {
            nowNode.next = head.next;
            head.next = nowNode;
            nowNode.previous = head;
        }
    }

    public void addBack(String str, List<Transfer> transfer) {
        Node nowNode = new Node(str, transfer);
        if (tail.previous == head) {
            nowNode.previous = head;
            tail.previous = nowNode;
            nowNode.next = tail;
            head.next = nowNode;
        } else {
            tail.previous.next = nowNode;
            nowNode.previous = tail.previous;
            nowNode.next = tail;
            tail.previous = nowNode;
        }
    }

    public void remove(String str) {
        Node temp = head;

        while (!temp.str.equals(str)) {
            temp = temp.next;
        }
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
    }

    public void printList() throws NullPointerException{
        Node temp = head;


        while (temp != null) {
            try {
                if (temp.transfer != null){
                    System.out.printf("%s - %s (%s) line\n", temp.str, temp.transfer.get(0).getStation(), temp.transfer.get(0).getLine());
                } else {
                    System.out.println(temp.str);
                }
            }catch (Exception e) {
                System.out.println(temp.str);
            }
            temp = temp.next;
        }

    }


    public void connect(String station, String line2, String station2) {
        Node temp = head;
        while (temp != null) {
            if (temp.str.equals(station)) {
                Transfer transfer = new Transfer();
                transfer.setLine(line2);
                transfer.setStation(station2);
                temp.transfer.add(transfer);
            }
            temp = temp.next;
        }
    }
}
