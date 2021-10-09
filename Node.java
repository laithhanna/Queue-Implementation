/**
 * This class will be responsible for making node objects, which will be used to implement the Queue.
 * Each node will have 2 attributes: int value and a reference to the next node.
 */
public class Node {

    private int value; //these are the values that will be in our queue
    private Node next; // reference variable that will hold the address of the next node.

    //Make the constructor
    public Node(int value) {
        this.value = value;
        this.next = null; //by default each node will have a null reference that we will change when necessary.
    }

    //Create getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
