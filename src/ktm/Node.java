package ktm;

public class Node {
    
    Commodity data;

    Node next;

    Node prev;

    Node() {

    }

    Node(Commodity d) {
        data = d;
    }

    Node(Commodity d, Node n , Node p) {
        data = d;
        next = n;
        prev = p;
    }
    
}
