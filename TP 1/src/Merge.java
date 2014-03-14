/**
 * Created with IntelliJ IDEA.
 * User: Flia Moreno
 * Date: 12/03/14
 * Time: 00:52
 * To change this template use File | Settings | File Templates.
 */
public class Merge {
    /**
     * Metodo que junta los elementos de dos arrays metiendolos en uno.
     * @param a : Array de elementos que implementen la interfaz Comparable
     * @param b : Array de elementos que implementen la interfaz Comparable
     * @return : Un Array con los elementos de a y b.
     */
    public Comparable[] merge(Comparable[] a, Comparable[] b){
        int totalLength = (a.length + b.length);
        System.out.println(totalLength);
        Comparable[] c = new Comparable[totalLength];
        int f = 0;
        for (int i = 0; i <c.length ; i++) {
            if(i<a.length){
                c[i] = a[i];
            }
            else{
                c[i] = b[f];
                f++;
            }
        }
        return c;
    }
}
