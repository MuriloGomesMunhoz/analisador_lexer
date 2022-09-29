import static java.lang.Character.isDigit;

public class FLUTUANTE implements AFD {
    @Override
    public Token processa(int pos, String texto) {
        String aux = "";
        int validaPonto = 0;
        for(pos = pos; pos < texto.length();pos++){
            if(isDigit(texto.charAt(pos))){
                aux+=texto.charAt(pos);
            }
            else if(texto.charAt(pos) == '.' && validaPonto == 0){
                validaPonto++;
                aux+=texto.charAt(pos);
            }

            if(texto.charAt(pos) == ' ' && validaPonto == 1){
                return new Token("FLUTUANTE", aux, aux.length());
            }

        }
        return null;
    }
}

