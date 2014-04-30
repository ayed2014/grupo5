/**
 * Created by Paca on 4/29/14.
 */
public class Lampara implements Comparable {
    private String clave;
    private int watts;
    private String tipoDeLampara;
    private int cantidad;

    public Lampara(String clave){
        this.clave = clave;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public void setTipoDeLampara(String tipoDeLampara) {
        this.tipoDeLampara = tipoDeLampara;
    }

    public void addOneCantidad() {
        cantidad ++;
    }

    public void restOneCantidad(){
        cantidad --;
    }

    public String getClave() {
        return clave;
    }

    public int getWatts() {
        return watts;
    }

    public String getTipoDeLampara() {
        return tipoDeLampara;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public int compareTo(Object o) {
        return clave.compareTo(o.toString());
    }
}
