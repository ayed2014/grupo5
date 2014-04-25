package PriorityQueue;

/**
 * Created by Paca on 4/17/14.
 */
public class PriorityObject implements Priorizable {
    private int priority;

    public PriorityObject(int priority){
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
