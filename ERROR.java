public class ERROR implements AFD {
    @Override
    public Token processa(int pos, String texto) {
        String aux = String.valueOf(texto.charAt(pos));

        return new Token("ERROR", aux, aux.length());
    }
}