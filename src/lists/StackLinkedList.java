package lists;


/**
 * Clase Stack (pila)
 *
 * @author Paz Hernandez
 */

public class StackLinkedList <Point> implements Stack<Point>  {
    private int total;

    private Node first;
    private class Node {
        private Point ele;
        private Node next;
    }

    public StackLinkedList() { }

    public StackLinkedList<Point> push(Point ele)
    {
        Node current = first;
        first = new Node();
        first.ele = ele;
        first.next = current;
        total++;
        return this;
    }

    public Point pop()
    {
        if (first == null) new java.util.NoSuchElementException();
        Point ele = first.ele;
        first = first.next;
        total--;
        return ele;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.ele).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

}
