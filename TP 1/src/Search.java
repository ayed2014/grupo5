/**
 * Created with IntelliJ IDEA.
 * User: Flia Moreno
 * Date: 06/03/14
 * Time: 02:09
 * To change this template use File | Settings | File Templates.
 */
public class Search {


    /**
     * Metodo que busca un elemento dentro de un array.
     * @param a : Array de elementos comparables.
     * @param k : Elemento comparable.
     * @return : devuelve la posicion del mismmo dentro del array, en caso de no encontrarse
     *           devuelve -1.
     */

    public int secuencialSearch(Comparable [] a, Comparable k){
        for (int i = 0; i < a.length ; i++) {
            if(a[i].compareTo(k) == 0){
                return i;
            }

        }
        return -1;
    }

    /**
     * Metodo que busca un elemento dentro de un array ordenado, su busqueda se basa en ir buscando de
     * a mitades.
     * @param a : array de elementos comparables.
     * @param k : un elemento comparable.
     * @return : devuelve la posicion del elemento, en caso de no encontrarse devuelve -1.
     */
    public int binarySearch(Comparable [] a, Comparable k){
        int min = 0;
        int max = a.length-1;
        int mid = (min+max)/2;

        while(min<=max){
            if(k.compareTo(a[mid]) == 0){
                return mid;
        }else if(k.compareTo(a[mid]) < 0){
             max = mid-1;
        }
        else
            min = mid+1;
            mid = (min+max)/2;
        }
    return -1;
    }

}
