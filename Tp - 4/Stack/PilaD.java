package Stack;import java.lang.Object;import java.lang.Override;

/**
 * Created by Paca on 3/28/14.
 */
public class PilaD implements Pila {
    public Nodo siguiente;

    public PilaD(){
        siguiente = null;
    }
    @Override
    public void apilar(Object objetoParaApilar) {
        Nodo auxNodo = siguiente;
        siguiente = new Nodo(objetoParaApilar);
        siguiente.nodo = auxNodo;
    }

    @Override
    public void desapilar() {
        siguiente = siguiente.nodo;

    }

    @Override
    public Object verTope() {
        return siguiente.object;
    }
}
