package lists;

/**
 * Clase LinkedList
 *
 * @author Paz Hernandez
 */
public class LinkedList {
    private Node first = null;

    public void insertFirst(int data) {
        Node n = new Node(data);
        n.next = first;
        first = n;
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
