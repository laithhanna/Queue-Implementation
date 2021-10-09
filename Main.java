/**
 * This class will be used to test our queue!
 * Notes: This queue is implemented using Singly LinkedList. Also, remember that queues follow the FIFO principle (First In First Out)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.printQueue();

        System.out.printf("\n%d has been removed from the queue\n\n", queue.dequeue());
        queue.printQueue();

        try {
            for (int i = 0; i < 5; i++) {
                queue.dequeue();
            }
        } catch (Exception E) {
            System.out.println("\nQueue is empty. There are no elements to dequeue");
        }

        try {
            queue.peek();
        } catch (Exception E) {
            System.out.printf("\nThe queue is empty!\nThe size of the queue: %d", queue.size());
        }
    }
}
