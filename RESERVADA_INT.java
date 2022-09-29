public class RESERVADA_INT implements AFD {

    @Override
    public Token processa(int pos, String texto) {
        String aux = "";

        for(pos = pos; pos < texto.length();pos++){
            aux+=texto.charAt(pos);
            if(texto.charAt(pos) == ' ' ){
                aux = aux.substring(0, aux.length()-1);
                if (aux.equals("int")) {
                     return new Token("RESERVADA_INT", "int", aux.length());
                }
            }
        }

        return null;

    }
}