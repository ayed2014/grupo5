import java.io.Serializable;

/**
 * Created by Paca on 4/23/14.
 */
public class ArBin implements Serializable {
    NodoDoble root;

    public ArBin(){
        root = null;
    }

    public ArBin(Object rootObject){
        root = new NodoDoble();
        root.object = rootObject;
    }

    public ArBin(Object rootObject, ArBin rightSon, ArBin leftSon){
        root = new NodoDoble();
        root.object = rootObject;
        root.rightSon = rightSon.root;
        root.leftSon = leftSon.root;
    }

    public ArBin(Object rootObject, ArBin rightSon){
        root = new NodoDoble();
        root.object = rootObject;
        root.rightSon = rightSon.root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Object getRoot(){
        return root.object;
    }

    public ArBin getLefSon(){
        ArBin auxArBin = new ArBin();
        auxArBin.root = root.leftSon;
        return auxArBin;
    }

    public ArBin getRightSon(){
        ArBin auxArBin = new ArBin();
        auxArBin.root = root.rightSon;
        return  auxArBin;

    }
}
