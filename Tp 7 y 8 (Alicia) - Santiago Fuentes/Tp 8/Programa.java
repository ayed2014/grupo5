import java.util.ArrayList;

/**
 * Created by Paca on 4/29/14.
 */
public class Programa {
    ArBinBus stock;

    public Programa(ArrayList<Lampara> lamparas){
        stock = new ArBinBus();
        for(Lampara lampara :lamparas){
            agregarLampara(lampara);
        }
    }

    public void agregarLampara(Lampara lampara){
        if (stock.existe(lampara)){
            stock.eliminar(lampara);
            lampara.addOneCantidad();
            stock.insertar(lampara);
        }else {
            stock.insertar(lampara);
        }
    }

    public void eliminarLampara(Lampara lampara){
        if (stock.existe(lampara)){
            stock.eliminar(lampara);
            lampara.restOneCantidad();
            stock.insertar(lampara);
        }else {
            System.out.println("\nSin stock de lamparas con esa clave\n");
        }
    }

    public void modificarLampara(Lampara lampara, int watts, String tipoDeLampara ){
        if (stock.existe(lampara)){
            stock.eliminar(lampara);
            lampara.setWatts(watts);
            lampara.setTipoDeLampara(tipoDeLampara);
            stock.insertar(lampara);
        }else {
            System.out.println("\nSin stock de lamparas con esa clave\n");
        }
    }

    public void informe(){
        ArBinBus stockAux = stock;

        while (!stockAux.esVacio()){
            Lampara lamparaAux = (Lampara) stock.getMin();
            System.out.println("\nClave: " + lamparaAux.getWatts() + "\nWatts: " + lamparaAux.getWatts() + "\nTipo de lampara: " + lamparaAux.getTipoDeLampara()
            + "\nCantidad: " + lamparaAux.getCantidad() );
            stockAux.eliminar(lamparaAux);

        }
    }
}
