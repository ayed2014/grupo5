import Bank.Person;
import Queue.QueueD;


/**
 * Created by Paca on 4/17/14.
 */
public class Tester {
    public static void main(String[] args) {
        QueueD queueD = new QueueD();

        for (int i = 0; i < 3 ; i++) {
            queueD.enqueue(new Person());
        }

        queueD.dequeue();
        queueD.dequeue();
        queueD.dequeue();

    }
}
