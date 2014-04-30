package ArBinInt;

/**
 * Created by Paca on 4/26/14.
 */
public class ArBinIntApi {
    public static int suma(ArBinInt arBinParaSumar){
        if (arBinParaSumar.isEmpty()){
            return 0;
        }else {
            return arBinParaSumar.getNumber() + (suma(arBinParaSumar.getRightSon()) + suma(arBinParaSumar.getLefSon()));
        }
    }

    public static int sumaDeMultiplosDeTres(ArBinInt arBinParaSumar){
        if (arBinParaSumar.isEmpty()){
            return 0;
        }else {
            if (arBinParaSumar.getNumber() % 3 == 0 && arBinParaSumar.getNumber() != 0){
                return arBinParaSumar.getNumber() + ((sumaDeMultiplosDeTres(arBinParaSumar.getRightSon()) + sumaDeMultiplosDeTres(arBinParaSumar.getLefSon())));
            }else {
                return (sumaDeMultiplosDeTres(arBinParaSumar.getRightSon()) + sumaDeMultiplosDeTres(arBinParaSumar.getLefSon()));
            }

        }

    }
}
