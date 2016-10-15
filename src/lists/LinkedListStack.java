package lists;


/**
 * Clase LinkedListStack (pila)
 *
 * @author Paz Hernandez
 */

public class LinkedListStack {

    LinkedList li = new LinkedList();

    public void push(int data) {
        li.insertFirst(data);
    }

    public void pop() {
        while(!li.isEmpty()){
            li.deleteFirst();
        }
    }

    public void displayStack() {
        System.out.println("  ");
        li.displayList();
    }
}
