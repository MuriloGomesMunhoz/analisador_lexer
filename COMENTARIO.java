import javax.print.attribute.standard.Finishings;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;

public class COMENTARIO implements AFD {

    int ini = 0;
    int fim = 0;

    @Override
    public Token processa(int pos, String texto) {
        String aux = "";
        ini = pos;
        for(pos = pos; pos < texto.length();pos++){

            aux+=texto.charAt(pos);
            if(texto.charAt(pos) == ' ' ){
                aux = aux.substring(0, aux.length()-1);
                fim = aux.length();
                if(texto.charAt(ini) == ' '){
                    if (texto.charAt(ini+1) == '"' && (texto.charAt(fim-1) == '"') ) {
                        return new Token("COMENTARIO", aux, aux.length());
                    }
                }
                else if(texto.charAt(ini) != ' '){
                    if (texto.charAt(ini) == '"' ) {
                        return new Token("COMENTARIO", aux, aux.length());
                    }
                }
                else if(texto.charAt(fim) != ' '){
                    if (texto.charAt(ini+1) == '"' && (texto.charAt(fim) == '"') ) {
                        return new Token("COMENTARIO", aux, aux.length());
                    }
                }else{
                    if (texto.charAt(ini+1) == '"' && (texto.charAt(fim-1) == '"') ) {
                        return new Token("COMENTARIO", aux, aux.length());
                    }
                }



            }

        }
        return null;

    }
}
