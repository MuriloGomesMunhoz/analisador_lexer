public class RESERVADA_RETURN implements AFD {

    @Override
    public Token processa(int pos, String texto) {
        String aux = "";

        for(pos = pos; pos < texto.length();pos++){

            aux+=texto.charAt(pos);

            if(texto.charAt(pos) == '!' || texto.charAt(pos) == ' ' ){
                aux = aux.substring(0, aux.length()-1);
                if (aux.equals("return")) {

                    return new Token("RESERVADA_RETURN", "return", aux.length());
                }


            }

        }
        return null;

    }
}