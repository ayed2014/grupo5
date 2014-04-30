/**
 * Created by Paca on 4/26/14.
 */
public class Tester {
    public static void main(String[] args) {

        ArBin arBin0 = new ArBin(0);
        ArBin arBin1 = new ArBin(1, arBin0,arBin0);
        ArBin arBin2 = new ArBin(2, arBin1, arBin1);
        ArBin arBin3 = new ArBin(3, arBin2, arBin2);


        System.out.println("El arbol mostrado en pre order: ");
        ArBinApi.preOrder(arBin3);
        System.out.println("\nEl arbol mostrado en in order: ");
        ArBinApi.inOrder(arBin3);
        System.out.println("\nEl arbol mostrado en post order: ");
        ArBinApi.postOrder(arBin3);
        System.out.println("\nPeso del arbol: " + ArBinApi.getWeight(arBin3));
        System.out.println("\nCantidad de hojas: " + ArBinApi.getLeafs(arBin3));
        System.out.println("\nCantidad de veces que se repite el numero 2: " + ArBinApi.getElementRepeat(2,arBin3));
        System.out.println("\nCantidad de elementos del nivel 2: " + ArBinApi.getElementsOfALevel(2,arBin3,0));
        System.out.println("\nAltura del arbol: " + ArBinApi.getHeight(arBin3));
        System.out.println("\nEl arbol esta completo? " + ArBinApi.estaCompleto(arBin3));
        System.out.println("\nFrontera: ");
        ArBinApi.mostrarFrontera(arBin3);

    }
}
