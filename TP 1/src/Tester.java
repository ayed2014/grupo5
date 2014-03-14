/**
 * Created with IntelliJ IDEA.
 * User: Flia Moreno
 * Date: 12/03/14
 * Time: 00:09
 * To change this template use File | Settings | File Templates.
 */
public class Tester {
    public static void main(String[] args) {
        Integer[] arrayInt = {5,9,1,4,3,8,2,6,7,0};
        Integer[] arrayInt2 = {90,80,10,15};
        Sort so = new Sort();
        Timer t = new Timer();
        Merge me = new Merge();
        for (int i = 0; i <arrayInt.length ; i++) {
            System.out.println("1er array : " + arrayInt[i]);

        }
        for (int i = 0; i <arrayInt2.length ; i++) {
            System.out.println("2do array : " + arrayInt2[i]);
        }
        Comparable[] c = me.merge(arrayInt,arrayInt2);
        so.insertionSort(c);
        Float timer = t.insertionAlgorithmTimer(c);

        System.out.println("Resultado Array: ");
        for (int i = 0; i <c.length ; i++) {
            System.out.println(c[i]);
        }
        System.out.println("Tiempo estimado para ordenar : " + timer);
    }
}
