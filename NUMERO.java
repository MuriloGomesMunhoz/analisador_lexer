import static java.lang.Character.isDigit;

public class NUMERO implements AFD {
    @Override
    public Token processa(int pos, String texto) {
        String aux = "";

        for(pos = pos; pos < texto.length();pos++){
            if(isDigit(texto.charAt(pos)) || texto.charAt(pos) == ' '){
                aux+=texto.charAt(pos);
            }else{
                return null;
            }
            if((texto.charAt(pos) == '!' || texto.charAt(pos) == ' ')){
                aux = aux.substring(0, aux.length()-1);
                    return new Token("NUMERO", aux, (aux.length()));

            }

        }
        return null;
    }
}
