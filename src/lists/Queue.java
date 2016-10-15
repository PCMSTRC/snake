package lists;

/**
 * Interface para Queues (Colas)
 *
 * @author Paz Hernandez
 */
public interface Queue <Point> {
    Queue <Point> enqueue (Point ele);
    Point dequeue();


}
