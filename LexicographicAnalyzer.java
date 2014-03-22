import java.io.*;

/**
 * Created by Paca on 3/20/14.
 */
public class LexicographicAnalyzer {
    private FileReader textoToAnalize;

    public LexicographicAnalyzer(String direccion) {
        try{
        textoToAnalize = new FileReader(direccion);
        }catch (FileNotFoundException e){

        }

    }

    public boolean isCorrect(){
        try{
            BufferedReader bufferTextToAnalize = new BufferedReader(textoToAnalize);
            String bufferText = bufferTextToAnalize.readLine();
            String completeText = null;

            while (bufferText != null){
                if(completeText != null){
                    completeText = completeText + bufferText;
                }else {
                    completeText = bufferText;
                }

                bufferText = bufferTextToAnalize.readLine();
            }
            return checkText(completeText);


        }catch (IOException e){

            }
        return false;
    }

    private boolean checkText(String text){
        Pila keyStack = new PilaE();
        Pila bracketStack = new PilaE();
        Pila parenthesisStack = new PilaE();
        int counter = 0;

        while (counter < text.length()){
            if (text.charAt(counter) == '{' || text.charAt(counter) == '}'){
                keyStack.apilar(text.charAt(counter));
            }
            if (text.charAt(counter) == '[' || text.charAt(counter) == ']'){
                bracketStack.apilar(text.charAt(counter));
            }
            if (text.charAt(counter) == '(' || text.charAt(counter) == ')'){
                parenthesisStack.apilar(text.charAt(counter));
            }
            counter++;
        }

        while (keyStack.verTope() != null){
            Object lastKey =  keyStack.verTope();
            keyStack.desapilar();
            if (lastKey == keyStack.verTope()){
                return false;
            }

        }

        while (bracketStack.verTope() != null){
            Object lastBracket =  bracketStack.verTope();
            bracketStack.desapilar();
            if (lastBracket == bracketStack.verTope()){
                return false;
            }

        }

        while (parenthesisStack.verTope() != null){
            Object lastParenthesis =  parenthesisStack.verTope();
            parenthesisStack.desapilar();
            if (lastParenthesis == bracketStack.verTope()){
                return false;
            }

        }

        return true;
    }


}
