package Queue;

/**
 * Created by Paca on 4/2/14.
 */
public class QueueD implements Queue {
    Nodo front;
    Nodo end;
    int lenght;

    public QueueD(){
        end = null;
        front = end;
        lenght = 0;
    }
    @Override
    public void enqueue(Object objectToEnqueue) {
        if (end == null){
            front = new Nodo(objectToEnqueue);
            end = front;
            lenght++;
        }else {
            end.nodo = new Nodo(objectToEnqueue);
            end = end.nodo;
            lenght ++;
        }
    }

    @Override
    public Object dequeue() {
        if (front != null){
            Nodo auxNodo = front;
            front = front.nodo;
            lenght --;
            return auxNodo.object;
        }else {
            front = null;
            lenght --;
            end = null;
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (lenght == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int lenght() {
        return lenght;
    }

    @Override
    public Object getFirst() {
        return front.object;
    }
}
