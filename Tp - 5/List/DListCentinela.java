package List;

/**
 * Created by Paca on 4/11/14.
 */
public class DListCentinela implements List {
        private Nodo window;
        private Nodo head;
        private Nodo sentinel;
        private int lenght;

        public DListCentinela(){
            head = new Nodo(null);
            sentinel = new Nodo(null);
            window = head;
            head.nodo = sentinel;
            lenght = 0;
        }

        @Override
        public Object seeActual() {
            if (window.equals(head)){
                return null;
            } else {
                return window.object;
            }
        }


        @Override
        public void empty() {
            head = new Nodo(null);
            sentinel = new Nodo(null);
            window = head;
            head.nodo = sentinel;
            lenght = 0;
        }

        @Override
        public boolean isEmpty() {
            return lenght == 0;
        }

        @Override
        public void insertBefore(Object objectToInsert) {
            Nodo auxNodo = new Nodo(objectToInsert);

            if (head.nodo.object == null){
                head.nodo = auxNodo;
                head.nodo.nodo = sentinel;
            }else {
                Nodo auxHeadNodo = head;

                while (auxHeadNodo.nodo.object != window.object){
                    auxHeadNodo = auxHeadNodo.nodo;
                }
                auxHeadNodo.nodo = auxNodo;
                auxNodo.nodo = window;
            }

            window = auxNodo;
            lenght ++;
        }

        @Override
        public void insertAfter(Object objectToInsert) {
            Nodo auxNodo = new Nodo(objectToInsert);
            auxNodo.nodo = window.nodo;
            window.nodo = auxNodo;
            window = auxNodo;
            lenght ++;
        }

        @Override
        public void next() {
            if (window.nodo.nodo != null){
                window = window.nodo;
            } else {
                System.out.println("Estas en la ultima posicion");
            }
        }

        @Override
        public void previous() {
            if (!isEmpty()){
                Nodo an = head;
                Nodo ac = head.nodo;

                while (ac != window){
                    an = ac;
                    ac = ac.nodo;
                    }

                if (an.object != null){
                    window = an;
                }
            }

        }


        @Override
        public void goTo(int x) {
            if (!isEmpty()){
                window = head.nodo;
                int xActual = 0;
                while (xActual < x){
                    xActual++;
                    window = window.nodo;
                }
            }
        }

        @Override
        public void delete() {
            Nodo auxNodo = head;

            while (auxNodo.nodo.object != window.object){
                auxNodo = auxNodo.nodo;
            }

            auxNodo.nodo = auxNodo.nodo.nodo;
            window = auxNodo;

        }

        @Override
            public void modify(Object objectToModify) {
                window.object = objectToModify;
            }


}
