import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class ID implements AFD {
    @Override
    public Token processa(int pos, String texto) {
        String aux = "";

        for(pos = pos; pos < texto.length();pos++){
            if(texto.charAt(pos) == '!' || texto.charAt(pos) == ' ' ){
                return new Token("ID", aux, aux.length());

            }
            else if(isLetter(texto.charAt(pos))){
                aux+=texto.charAt(pos);
            }else{
                return null;

            }
        }
        return null;
    }
}

