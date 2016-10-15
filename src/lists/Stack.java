package lists;

/**
 * Interface para stack (pila)
 *
 * @author Paz Hernandez
 */

public interface Stack <Point> {
    Stack <Point> push (Point ele);
    Point pop();
}
