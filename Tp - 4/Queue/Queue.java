package Queue; /**
 * Created by Paca on 3/28/14.
 */
public interface Queue {
    public void enqueue(Object objetoToEnqueue);
    public Object dequeue();
    public boolean isEmpty();
    public int lenght();
    public Object getFirst();

}
