/**
 * Created with IntelliJ IDEA.
 * User: Flia Moreno
 * Date: 11/03/14
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class Sort {

    /**
     * Metodo que ordena mediante el algoritmo de selección que consiste en encontrar el menor valor del array
     * y meterlo en la fila. Utiliza un metodo recursivo llamado change.
     * @param a : array de elementos que implementen la interfaz Comparable.
     */


    public void selectionSort(Comparable a[]){
        Comparable minimo;
        int posicion;
        for(int i = 0; i< a.length-1; i++){
            minimo = a[i];
            posicion = i;
            for (int j =i+1; j < a.length ; j++) {
                if(a[j].compareTo(minimo)<0){
                    minimo = a[j];
                    posicion = j;
                }
            }
            change(a[i],a[posicion],a,i,posicion);
        }
    }

    /**
     * Metodo recursivo que cambia de lugar elementos en un array.
     */
    private void change(Comparable a, Comparable b, Comparable arr[], int pos1, int pos2){
        if(pos2 != pos1){
            Comparable auxiliar = a;
            arr[pos2] = auxiliar;
            arr[pos1] = b;


        }
    }

    public void insertionSort(Comparable a[]){
        Comparable auxiliar;
        int posicion;
        for (int i = 0; i <a.length ; i++) {
        posicion = i;
            while (posicion>0 && a[posicion].compareTo(a[posicion-1])<0){
                auxiliar = a[posicion];
                a[posicion] = a[posicion-1];
                a[posicion-1] = auxiliar;
                posicion--;
            }
        }
    }

    public void bubbleSort(Comparable a[]){
        Comparable auxiliar;
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j =i+1; j < a.length ; j++) {
                if(a[j].compareTo(a[i])<0){
                    auxiliar = a[j];
                    a[j] = a[i];
                    a[i] = auxiliar;
                }
            }
        }
    }
}

