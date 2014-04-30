package ArBinInt;

/**
 * Created by Paca on 4/26/14.
 */
public class ArBinInt {
    NodoDobleInt root;

    public ArBinInt(){
        root = null;
    }

    public ArBinInt(int number){
        root = new NodoDobleInt();
        root.number = number;
    }

    public ArBinInt(int number, ArBinInt rightSon, ArBinInt leftSon){
        root = new NodoDobleInt();
        root.number = number;
        root.rightSon = rightSon.root;
        root.leftSon = leftSon.root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getRoot(){
        return root.number;
    }

    public ArBinInt getLefSon(){
        ArBinInt auxArBin = new ArBinInt();
        auxArBin.root = root.leftSon;
        return auxArBin;
    }

    public ArBinInt getRightSon(){
        ArBinInt auxArBin = new ArBinInt();
        auxArBin.root = root.rightSon;
        return  auxArBin;

    }

    public int getNumber(){
        return root.number;
    }
}
