public class SUB implements AFD {

    @Override
    public Token processa(int pos, String texto) {
        char current_char = texto.charAt(pos);
        if (current_char == '-') {
            return new Token("SUB", "-", 1);
        }
        return null;
    }
}