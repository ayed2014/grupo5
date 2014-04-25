package Stack;import java.lang.Object;

/**
 * Created by Paca on 3/14/14.
 */
public class PilaE implements Pila{
    Object[] repositorio;
    int index;

    public PilaE(){
        repositorio = new Object[10];
        index = 0;
    }

    public void apilar(Object objectParaApilar){

        if (index == repositorio.length){
            agrandarRepositorio();
        }
        index++;
        repositorio[index] = objectParaApilar;
    }

    public void desapilar(){
        if (index >= 0){
        index--;
        }
    }

    public Object verTope(){
        if (index >= 0){
        return repositorio[index];
        }else{
            return null;
        }
    }

    private void agrandarRepositorio(){
        Object[] repositorioTemporario = new Object[index + 10];

        for (int i = 0; i < repositorio.length ; i++) {
            repositorioTemporario[i] = repositorio[i];
        }
        repositorio = repositorioTemporario;
    }
}
