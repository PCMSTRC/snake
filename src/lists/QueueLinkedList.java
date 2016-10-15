package lists;

/**
 * Clase Queue (Cola)
 *
 * @author Paz Hernandez
 */


public class QueueLinkedList<Point> implements Queue<Point> {

    private int total;

    private Node first, last;

    private class Node {
        private Point ele;
        private Node next;
    }

    public QueueLinkedList() { }

    public QueueLinkedList<Point> enqueue(Point ele)
    {
        Node current = last;
        last = new Node();
        last.ele = ele;

        if (total++ == 0) first = last;
        else current.next = last;

        return this;
    }

    public Point dequeue()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        Point ele = first.ele;
        first = first.next;
        if (--total == 0) last = null;
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