/**
 * Created with IntelliJ IDEA.
 * User: Flia Moreno
 * Date: 13/03/14
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public class Timer {

   public float bubbleAlgorithmTimer(Comparable a[]){
       float start = System.nanoTime();
       Sort s = new Sort();
       s.bubbleSort(a);
       float finish = System.nanoTime();
       return (finish - start);

   }
   public float insertionAlgorithmTimer(Comparable a[]){
       float start = System.nanoTime();
       Sort s = new Sort();
       s.insertionSort(a);
       float finish = System.nanoTime();
       return (finish - start);
   }
   public float selectionAlgorithmTimer(Comparable a[]){
       float start = System.nanoTime();
       Sort s = new Sort();
       s.selectionSort(a);
       float finish = System.nanoTime();
       return (finish - start);
   }
}
