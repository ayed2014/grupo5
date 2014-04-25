package Queue; /**
 * Created by Paca on 3/28/14.
 */
public class QueueE implements Queue {
    Object[] data;
    int front;
    int end;
    int lenght;

    public QueueE(){
        data = new Object[10];
        front = 0;
        end = 0;
        lenght = 0;
    }

    @Override
    public void enqueue(Object objetoToEnqueue) {
        if(lenght != data.length){
            data[end] = objetoToEnqueue;

            if (end != data.length ){
                end ++;
            }else {
                end = 0;
            }
            lenght ++;
        } else {
            reSize();
            enqueue(objetoToEnqueue);
        }
    }

    @Override
    public Object dequeue() {
        if (front != data.length - 1){
            front ++;
            lenght --;
            return data[front - 1];
        }else {
            front = 0;
            lenght --;
            return data[data.length -1];
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

    public void reSize() {
        Object[] dataAux = new Object[data.length + 10];
         if (front < end){

             for (int i = 0; i < end ; i++) {
                dataAux[i] = data[i];
             }
         }else {
             int j = 0;
             for (int i = front; i < data.length ; i++) {
                 dataAux[j] = data[i];
                 j++;
             }

             for (int i = 0; i <= end ; i++) {
                 dataAux[j] = data[i];
                 j++;
             }

         }

        data = dataAux;

    }

    public Object getFirst(){
        return data[front];
    }


}
