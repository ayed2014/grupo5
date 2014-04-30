/**
 * Created by Paca on 4/29/14.
 */
public class ArBinBus {
    private NodoDoble raiz;

    public ArBinBus(){
        raiz = null;
    }

    public void insertar(Comparable lamparaParaInserter){
        raiz = insertar(raiz, lamparaParaInserter);
    }

    public void eliminar(Comparable lamparaParaEliminar){
        raiz = eliminar(raiz, lamparaParaEliminar);
    }

    public Object getMin(){
        return getMin(raiz).object;
    }

    public Object getMax(){
        return getMax(raiz).object;
    }

    public Object buscar(Comparable lamparaParaBuscar){
        return buscar(raiz, lamparaParaBuscar).object;
    }

    public boolean existe(Comparable lamparaParaVerificar){
        return existe(raiz, lamparaParaVerificar);
    }

    public boolean esVacio(){
        return (raiz == null);
    }

    public Object getRaiz(){
        return raiz.object;
    }

    public ArBinBus hijoIzquierdo(){
        ArBinBus arBinBusAux = new ArBinBus();
        arBinBusAux.raiz = raiz.leftSon;
        return arBinBusAux;
    }

    public ArBinBus hijoDerecho(){
        ArBinBus arBinBusAux = new ArBinBus();
        arBinBusAux.raiz = raiz.rightSon;
        return arBinBusAux;
    }

    private NodoDoble getMax(NodoDoble arBinBusParaAnalizar){
        if (arBinBusParaAnalizar.rightSon == null){
            return arBinBusParaAnalizar;
        }else {
            return getMax(arBinBusParaAnalizar.rightSon);
        }
    }

    private NodoDoble getMin(NodoDoble arBinBusParaAnalizar){
        if (arBinBusParaAnalizar.leftSon == null){
            return arBinBusParaAnalizar;
        }else {
            return getMin(arBinBusParaAnalizar.leftSon);
        }
    }

    private NodoDoble buscar(NodoDoble arBinBusDondeBuscar, Comparable elementoABuscar){
        if (elementoABuscar.compareTo(arBinBusDondeBuscar.object) == 0 ){
            return arBinBusDondeBuscar;
        }else if (elementoABuscar.compareTo(arBinBusDondeBuscar.object) < 0){
            return buscar(arBinBusDondeBuscar.leftSon, elementoABuscar);
        }else {
            return buscar(arBinBusDondeBuscar.rightSon, elementoABuscar);
        }
    }

    private boolean existe(NodoDoble arBinDondeBuscar, Comparable elementoAverificar){
        if (arBinDondeBuscar == null){
            return false;
        }else if (elementoAverificar.compareTo(arBinDondeBuscar.object) == 0){
            return true;
        }else if (elementoAverificar.compareTo(arBinDondeBuscar.object) < 0){
            return existe(arBinDondeBuscar.leftSon, elementoAverificar);
        }else {
            return existe(arBinDondeBuscar.rightSon, elementoAverificar);
        }
    }

    private NodoDoble insertar(NodoDoble arBinDondeInsertar, Comparable elementoAInsertar){
        if (arBinDondeInsertar == null){
            arBinDondeInsertar = new NodoDoble();
            arBinDondeInsertar.object = elementoAInsertar;

        }if (elementoAInsertar.compareTo(arBinDondeInsertar.object) < 0){
            arBinDondeInsertar.leftSon =  insertar(arBinDondeInsertar.leftSon, elementoAInsertar);
        }else {
            arBinDondeInsertar.rightSon = insertar(arBinDondeInsertar.rightSon, elementoAInsertar);
        }
        return arBinDondeInsertar;
    }

    private NodoDoble eliminar(NodoDoble arBinDondeEliminar, Comparable elementoAEliminar){
        if (elementoAEliminar.compareTo(arBinDondeEliminar.object) < 0){
            arBinDondeEliminar.leftSon = eliminar(arBinDondeEliminar.leftSon, elementoAEliminar);
        }else if (elementoAEliminar.compareTo(arBinDondeEliminar.object) > 0){
            arBinDondeEliminar.rightSon= eliminar(arBinDondeEliminar.rightSon, elementoAEliminar);
        }else {
            if (arBinDondeEliminar.leftSon != null && arBinDondeEliminar.rightSon != null){
                arBinDondeEliminar.object = getMin(arBinDondeEliminar.rightSon).object;
                arBinDondeEliminar.rightSon = eliminarMin(arBinDondeEliminar.rightSon);
            }else if (arBinDondeEliminar.leftSon != null){
                arBinDondeEliminar = arBinDondeEliminar.leftSon;
            }else {
                arBinDondeEliminar = arBinDondeEliminar.rightSon;
            }
        }
        return arBinDondeEliminar;
    }

    private NodoDoble eliminarMin(NodoDoble arBinDondeEliminar){
        if (arBinDondeEliminar.leftSon != null){
            arBinDondeEliminar.leftSon = eliminarMin(arBinDondeEliminar.leftSon);
        }else {
            arBinDondeEliminar = arBinDondeEliminar.rightSon;
        }

        return arBinDondeEliminar;
    }

}
