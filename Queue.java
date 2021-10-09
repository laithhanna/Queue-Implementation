/**
 * This is the Queue class.
 * Remember that the queue follows the principle of FIFO (First In First Out)
 * Note that the Enqueue (insertion) and Dequeue (deletion) operations happens from two different ends.
 * Enqueue happens from the rear and Dequeue happens from the front of the queue.
 * This class will have 3 fields: reference to the rear, reference to the front and int size
 * front keeps track of the first element we enqueued and rear keeps track of the last element we enqueued
 */
public class Queue {
    private Node rear; //reference to the rear of the queue
    private Node front; //reference to the front of the queue
    private int size; //keep track of the size of the queue

    //make the constructor
    public Queue() {
        this.rear = null; //since the queue is empty at the start, rear reference will point to null
        this.front = null; //since the queue is empty at the start, front reference will point to null
        this.size = 0; //initially the size of the queue is 0
    }

    /**
     * Since we dequeue from the front side. It is enough to only check if the front reference points to null to determine if queue is empty.
     * @return true if the queue is empty (front == null)
     */
    public Boolean isEmpty() {
        return front == null;
    }

    /**
     * @return the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * @return the value of the first elements we inserted to the queue. If the queue is empty, an exception will be thrown
     * @throws Exception if the queue is empty.
     */
    public int peek() throws Exception {
        if (!isEmpty()) {
            return front.getValue();
        }
        throw new Exception("The queue is empty!");
    }

    /**
     * This method will enqueue (insert) a new element to the queue.
     * Remember to keep track of the rear reference, since the enqueueing operation happens from the rear side of the queue.
     * Remember that we are using LinkedList to implement the queue, so we need to create a node object to hold the value
     * Finally, make sure you are obeying the principle of FIFO (First In First Out)
     * @param value to be inserted to the queue.
     */
    public void enqueue(int value) {
        //First create the node that will hold the value
        Node n = new Node(value);
        //If the queue is empty then the rear and front will point to this first node
        if (isEmpty()) {
            rear = front = n; //address held in "n" will be stored in "front" and then will be stored in "rear" (Assignment is from right to left)
        } else {
            //Remember: we enqueue (insert) from the rear side of the queue
            //The next reference of the previously inserted node (which "rear" is pointing to) will point to the new node,
            //then the rear reference will point to the new node. the front reference will not move unless the dequeue operation is performed
            //increment the size of the queue
            rear.setNext(n);
            rear = n;
        }
        size++;
    }

    /**
     * This method will dequeue (remove) the node that the front reference is pointing to and return its value. Throw exception if queue is empty
     * Remember to keep track of the front reference, since the dequeuing operation happens from the front side of the queue.
     * Finally, make sure you are obeying the principle of FIFO (First In First Out)
     * @return the value of the node that will be removed
     * @throws Exception if the queue is empty
     */
    public int dequeue() throws Exception {
        if(isEmpty()) {
            throw  new Exception("Queue is empty!");
        }
        //Remember: We dequeue (delete) from the front side of the queue
        //We will put the value of the node we want to delete in a temp variable
        //Change the top reference to the next node. (we are obeying FIFO)
        //decrement the size of the queue
        //Return the temp variable
        int temp = front.getValue();
        front = front.getNext();

        //check if front is pointing to null. If, yes then the stack is empty and we need to make rear point to null as well
        //why are we doing this? We are doing this because if we are at the last node it means that front and rear points to this last node,
        // and if we said front = front.next then front = null however, the rear reference will still
        //hold the address of that node object so need to make rear points to null as well since the queue is empty now.
        if (front == null) {
            rear = null;
        }
        size--;
        return temp;
    }

    /**
     * This method will print the elements in the queue while obeying the FIFO principle (First In First Out)
     */
    public void printQueue() {
        //Check if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Printing the queue...");
            Node temp = front; //Created a temp reference variable that will point to the front of the queue
            while (temp != null) {
                System.out.printf("%d ", temp.getValue());
                temp = temp.getNext();
            }
            System.out.println("\nThe size of the queue: " + size);
        }
    }
}
