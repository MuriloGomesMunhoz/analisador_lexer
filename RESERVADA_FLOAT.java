import javax.swing.plaf.synth.SynthOptionPaneUI;

public class RESERVADA_FLOAT implements AFD {
    @Override
    public Token processa(int pos, String texto) {
        String aux = "";
        for(pos = pos; pos < texto.length();pos++){
            aux+=texto.charAt(pos);
            if(texto.charAt(pos) == '!' || texto.charAt(pos) == ' ' ){
                aux = aux.substring(0, aux.length()-1);
                if (aux.equals("float")) {
                    return new Token("RESERVADA_FLOAT", "float", aux.length());
                }
            }

        }
        return null;

    }
}
