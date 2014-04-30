import java.io.*;
import java.util.ArrayList;

/**
 * Created by Paca on 4/23/14.
 */
public class ArBinApi {
    public static int getWeight(ArBin arBinToAnalyze){
        if (arBinToAnalyze.isEmpty()){
            return 0;
        }else {
            return 1 + (getWeight(arBinToAnalyze.getRightSon()) + getWeight(arBinToAnalyze.getLefSon()));
        }
    }

    public static int getLeafs(ArBin arBinToAnalyze){
        if (arBinToAnalyze.isEmpty()){
            return 0;
        }else if (arBinToAnalyze.getLefSon().isEmpty() && arBinToAnalyze.getRightSon().isEmpty()){
            return 1;
        }else {
            return (getLeafs(arBinToAnalyze.getRightSon()) + getLeafs(arBinToAnalyze.getLefSon()));
        }
    }

    public static int getElementRepeat(Object objectToAnalyze, ArBin arBinToSearchIn ){
        if (arBinToSearchIn.isEmpty()){
            return 0;
        }else if (arBinToSearchIn.getRoot().equals(objectToAnalyze)){
            return 1 + (getElementRepeat(objectToAnalyze, arBinToSearchIn.getRightSon()) + getElementRepeat(objectToAnalyze, arBinToSearchIn.getLefSon()));
        }else {
            return (getElementRepeat(objectToAnalyze, arBinToSearchIn.getRightSon()) + getElementRepeat(objectToAnalyze, arBinToSearchIn.getLefSon()));
        }
    }

    public static int getElementsOfALevel(int level, ArBin arBinToAnalyze, int zero){
        int intAux = zero;
        if (!arBinToAnalyze.isEmpty() && zero == level){
            return 1;
        }else if (arBinToAnalyze.isEmpty()){
            return 0;
        }else {
            return (getElementsOfALevel(level, arBinToAnalyze.getRightSon(), intAux + 1) + getElementsOfALevel(level, arBinToAnalyze.getLefSon(), intAux + 1));
        }

    }

    public static int getHeight(ArBin arBinToAnalyze){
        if (esHoja(arBinToAnalyze)){
            return 0;
        }else {
            if (getHeight(arBinToAnalyze.getRightSon()) > getHeight(arBinToAnalyze.getLefSon())){
                return 1 + getHeight(arBinToAnalyze.getRightSon());
            }else {
                return 1 + getHeight(arBinToAnalyze.getLefSon());
            }
        }
    }

    public static boolean sonIguales(ArBin arBin1, ArBin arBin2){
        if (!arBin1.isEmpty() && !arBin2.isEmpty()){
            if (arBin1.getRoot().equals(arBin2.getRoot()) && !arBin1.isEmpty()){
                return (sonIguales(arBin1.getRightSon(),arBin2.getRightSon()) && sonIguales(arBin1.getLefSon(), arBin2.getLefSon()));
            }else {
                return false;
            }
        }else {
            return true;
        }
    }

    // Si son iguales tambien tira true, por definicion si son isomorfos no son iguales toDo
    public static boolean sonIsomorfos(ArBin arBin1, ArBin arBin2){
        if (arBin1.isEmpty() && arBin2.isEmpty()){
            return true;
        }else if (!arBin1.isEmpty() && !arBin2.isEmpty()){
            return true;
        }else {
            return (sonIsomorfos(arBin1.getRightSon(), arBin2.getRightSon()) && sonIsomorfos(arBin1.getLefSon(), arBin2.getLefSon()));
        }
     }

    /** todo
    public static boolean sonSemejantes(ArBin arBin1, ArBin arBin2){

    }
     */

    public static boolean estaCompleto(ArBin arBin){
        if (esHoja(arBin)){
            return true;
        }else if (!arBin.getLefSon().isEmpty() && !arBin.getRightSon().isEmpty()){
            return (estaCompleto(arBin.getLefSon()) && estaCompleto(arBin.getRightSon()));
        }else {
            return false;
        }
    }

    private static boolean esHoja(ArBin arBin){
        if (arBin.isEmpty() || (arBin.getRightSon().isEmpty() && arBin.getLefSon().isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    /**todo
    public static boolean estaLleno(ArBin arBin){
        if (esHoja(arBin)){

        }else {
            return ()
        }
    }
     */

    /** todo
    public static boolean estable(ArBin arBin){
        if (esHoja(arBin)){
            return true;
        }else {
            if ()

        }
    }
     */

    public static void mostrarFrontera(ArBin arBin){
        if (!arBin.isEmpty()){
            if (esHoja(arBin)){
                System.out.println(arBin.getRoot());
            }else {
                mostrarFrontera(arBin.getRightSon());
                mostrarFrontera(arBin.getLefSon());
            }
        }
    }

    public static void preOrder(ArBin arBin){
        if (!arBin.isEmpty()){
            System.out.println(arBin.getRoot());
            preOrder(arBin.getRightSon());
            preOrder(arBin.getLefSon());
        }
    }

    public static void inOrder(ArBin arBin){
        if (!arBin.isEmpty()){
            inOrder(arBin.getLefSon());
            System.out.println(arBin.getRoot());
            inOrder(arBin.getRightSon());
        }
    }

    public static void postOrder(ArBin arBin){
        if (!arBin.isEmpty()){
            postOrder(arBin.getLefSon());
            postOrder(arBin.getRightSon());
            System.out.println(arBin.getRoot());
        }
    }

    public static void porNiveles(ArBin arBin){
        //todo
    }

    public static void guardarArbolBin(ArBin arBin){
        try {
            FileOutputStream fs = new FileOutputStream("ArBin.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(arBin);
            oos.close();
        } catch (FileNotFoundException e){
        } catch (IOException e){
        }
    }

    public static ArBin recuperarArBolBien(){
        ArBin arBinAux = null;
        try{
            FileInputStream fs = new FileInputStream("Arbin.bin");
            ObjectInputStream ois = new ObjectInputStream(fs);

            arBinAux = (ArBin) ois.readObject();

            ois.close();
        }catch (FileNotFoundException e){
        }catch (IOException e){
        }catch (ClassNotFoundException e){
        }
        return arBinAux;
    }




}
