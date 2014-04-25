package PriorityQueue;

/**
 * Created by Paca on 4/17/14.
 */
public class Tester {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(3);

        for (int i = 0; i < 5; i++) {
            priorityQueue.enqueue(new PriorityObject(0));
            priorityQueue.enqueue(new PriorityObject(1));
            priorityQueue.enqueue(new PriorityObject(2));
        }

        for (int i = 0; i < 15 ; i++) {
            System.out.println(priorityQueue.dequeue().getPriority());
        }

    }

}
