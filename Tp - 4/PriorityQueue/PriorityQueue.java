package PriorityQueue;

import Queue.QueueD;

/**
 * Created by Paca on 4/17/14.
 */
public class PriorityQueue {
    private QueueD[] queueDs;
    private int amountOfPriority;

    public PriorityQueue(int amountOfPriority){
        queueDs = new QueueD[amountOfPriority];
        this.amountOfPriority = amountOfPriority;

        for (int i = 0; i < amountOfPriority ; i++) {
            queueDs[i] = new QueueD();
        }
    }

    public void enqueue(Priorizable objectToEnqueue){
        queueDs[objectToEnqueue.getPriority()].enqueue(objectToEnqueue);
    }

    public Priorizable dequeue(){
        for (int i = 0; i < amountOfPriority ; i++) {
            if (!queueDs[i].isEmpty()){
                return (Priorizable) queueDs[i].dequeue();
            }
        }
        return null;
    }

    public Priorizable getNext(){
        for (int i = 0; i < amountOfPriority; i++) {
            if (!queueDs[i].isEmpty()){
                return (Priorizable) queueDs[i].getFirst();
            }
        }

        return null;
    }
}
