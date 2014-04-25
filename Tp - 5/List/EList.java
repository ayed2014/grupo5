package List;

/**
 * Created by Paca on 4/4/14.
 */
public class EList implements List {
    Object[] data;
    int window;
    int length;

    public EList() {
        data = new Object[20];
        window = 0;
        length = 0;
    }

    @Override
    public Object seeActual() {
        return data[window];
    }

    @Override
    public void empty() {
        for (int i = 0; i < length ; i++) {
            data[i] = null;
        }
        window = 0;
    }

    @Override
    public boolean isEmpty() {
        if (length == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void insertAfter(Object objectToInsert) {
        if (length != data.length){
            if (length != 0){
                for (int i = length - 1; i > window ; i--) {
                    data[i + 1] = data[i];
                }
                window ++;
                data[window] = objectToInsert;
                length ++;
            }else{
                System.out.println("la lista esta vacia, inserte un elemento despues (insertBefore)");
            }
        }else {
            resize();
            insertAfter(objectToInsert);
        }
    }

    @Override
    public void insertBefore(Object objectToInsert) {
        if (length != data.length){
            for (int i = length - 1; i >= window ; i--) {
                data[i + 1] = data[i];
            }

            data[window] = objectToInsert;
            length++;
        }else {
            resize();
            insertBefore(objectToInsert);
        }
    }

    @Override
    public void next() {
        if (length != data.length){
            if (data[window + 1] != null){
                window++;
            }
        }else {
            resize();
            window++;
        }
    }

    @Override
    public void previous() {
        if (window != 0){
            window --;
        }
    }

    @Override
    public void goTo(int position) {
        if (position < length){
            window = position;
        } else {
            System.out.println("No hay nada en esa posicion");
        }
    }

    @Override
    public void delete() {
        for (int i = window; i < length ; i++) {
            data[i] = data[i + 1];
        }
        length --;
    }

    private void resize() {
        Object[] auxData = new Object[data.length + 10];
        for (int i = 0; i < data.length ; i++) {
            auxData[i] = data[i];
        }

        data = auxData;
    }

    @Override
    public void modify(Object objectToInsert) {
        data[window] = objectToInsert;
    }

    public int getLength(){
        return length;
    }
}
